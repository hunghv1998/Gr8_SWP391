<%-- 
    Document   : timetable
    Created on : Feb 25, 2022, 12:49:46 AM
    Author     : chinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "../common/nav.jsp" %>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
        <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>



        <div class="container theme-showcase">
                <h1>Thời gian biểu hằng ngày</h1>
            <div id="holder" class="row" ></div>
        </div>

        <script type="text/tmpl" id="tmpl">
        {{ 
        var date = date || new Date(),
        month = date.getMonth(), 
        year = date.getFullYear(), 
        first = new Date(year, month, 1), 
        last = new Date(year, month + 1, 0),
        startingDay = first.getDay(), 
        thedate = new Date(year, month, 1 - startingDay),
        dayclass = lastmonthcss,
        today = new Date(),
        i, j; 
        if (mode === 'week') {
        thedate = new Date(date);
        thedate.setDate(date.getDate() - date.getDay());
        first = new Date(thedate);
        last = new Date(thedate);
        last.setDate(last.getDate()+6);
        } else if (mode === 'day') {
        thedate = new Date(date);
        first = new Date(thedate);
        last = new Date(thedate);
        last.setDate(thedate.getDate() + 1);
        }

        }}
        <table class="calendar-table table table-condensed table-tight">
            <thead>
                <tr>
                    <td colspan="7" style="text-align: center">
                        <table style="white-space: nowrap; width: 100%">
                            <tr>
                                <td style="text-align: left;">
                                    <span class="btn-group">
                                        <button class="js-cal-prev btn btn-default"><</button>
                                        <button class="js-cal-next btn btn-default">></button>
                                    </span>
                                    <button class="js-cal-option btn btn-default {{: first.toDateInt() <= today.toDateInt() && today.toDateInt() <= last.toDateInt() ? 'active':'' }}" data-date="{{: today.toISOString()}}" data-mode="month">{{: todayname }}</button>
                                </td>
                                <td>
                                    <span class="btn-group btn-group-lg">
                                        {{ if (mode !== 'day') { }}
                                        {{ if (mode === 'month') { }}<button class="js-cal-option btn btn-link" data-mode="year">{{: months[month] }}</button>{{ } }}
                                        {{ if (mode ==='week') { }}
                                        <button class="btn btn-link disabled">{{: shortMonths[first.getMonth()] }} {{: first.getDate() }} - {{: shortMonths[last.getMonth()] }} {{: last.getDate() }}</button>
                                        {{ } }}
                                        <button class="js-cal-years btn btn-link">{{: year}}</button> 
                                        {{ } else { }}
                                        <button class="btn btn-link disabled">{{: date.toDateString() }}</button> 
                                        {{ } }}
                                    </span>
                                </td>
                                <td style="text-align: right">
                                    <span class="btn-group">
                                        <button class="js-cal-option btn btn-default {{: mode==='year'? 'active':'' }}" data-mode="year">Year</button>
                                        <button class="js-cal-option btn btn-default {{: mode==='month'? 'active':'' }}" data-mode="month">Month</button>
                                        <button class="js-cal-option btn btn-default {{: mode==='week'? 'active':'' }}" data-mode="week">Week</button>
                                        <button class="js-cal-option btn btn-default {{: mode==='day'? 'active':'' }}" data-mode="day">Day</button>
                                    </span>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </thead>
        {{ if (mode ==='year') {
                month = 0;
        }}
        <tbody>
            {{ for (j = 0; j < 3; j++) { }}
            <tr>
                {{ for (i = 0; i < 4; i++) { }}
                <td class="calendar-month month-{{:month}} js-cal-option" data-date="{{: new Date(year, month, 1).toISOString() }}" data-mode="month">
                    {{: months[month] }}
                    {{ month++;}}
                </td>
                {{ } }}
            </tr>
            {{ } }}
        </tbody>
        {{ } }}
        {{ if (mode ==='month' || mode ==='week') { }}
        <thead>
            <tr class="c-weeks">
                {{ for (i = 0; i < 7; i++) { }}
                <th class="c-name">
                    {{: days[i] }}
                </th>
                {{ } }}
            </tr>
        </thead>
        <tbody>
            {{ for (j = 0; j < 6 && (j < 1 || mode === 'month'); j++) { }}
            <tr>
                {{ for (i = 0; i < 7; i++) { }}
                {{ if (thedate > last) { dayclass = nextmonthcss; } else if (thedate >= first) { dayclass = thismonthcss; } }}
                <td class="calendar-day {{: dayclass }} {{: thedate.toDateCssClass() }} {{: date.toDateCssClass() === thedate.toDateCssClass() ? 'selected':'' }} {{: daycss[i] }} js-cal-option" data-date="{{: thedate.toISOString() }}">
                    <div class="date">{{: thedate.getDate() }}</div>
                    {{ thedate.setDate(thedate.getDate() + 1);}}
                </td>
                {{ } }}
            </tr>
            {{ } }}
        </tbody>
        {{ } }}
        {{ if (mode ==='day') { }}
        <tbody>
            <tr>
                <td colspan="7">
                    <table class="table table-striped table-condensed table-tight-vert" >
                        <thead>
                            <tr>
                                <th> </th>
                                <th style="text-align: center; width: 100%">{{: days[date.getDay()] }}</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th class="timetitle" >All Day</th>
                                <td class="{{: date.toDateCssClass() }}">  </td>
                            </tr>
                            <tr>
                                <th class="timetitle" >Before 6 AM</th>
                                <td class="time-0-0"> </td>
                            </tr>
                            {{for (i = 6; i < 22; i++) { }}
                            <tr>
                                <th class="timetitle" >{{: i <= 12 ? i : i - 12 }} {{: i < 12 ? "AM" : "PM"}}</th>
                                <td class="time-{{: i}}-0"> </td>
                            </tr>
                            <tr>
                                <th class="timetitle" >{{: i <= 12 ? i : i - 12 }}:30 {{: i < 12 ? "AM" : "PM"}}</th>
                                <td class="time-{{: i}}-30"> </td>
                            </tr>
                            {{ } }}
                            <tr>
                                <th class="timetitle" >After 10 PM</th>
                                <td class="time-22-0"> </td>
                            </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
        </tbody>
        {{ } }}
    </table>
    </script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script>
        var $currentPopover = null;
        $(document).on('shown.bs.popover', function (ev) {
            var $target = $(ev.target);
            if ($currentPopover && ($currentPopover.get(0) !== $target.get(0))) {
                $currentPopover.popover('toggle');
        }
        $currentPopover = $target;
        }).on('hidden.bs.popover', function (ev) {
            var $target = $(ev.target);
            if ($currentPopover && ($currentPopover.get(0) === $target.get(0))) {
                $currentPopover = null;
        }
        });


//quicktmpl is a simple template language I threw together a while ago; it is not remotely secure to xss and probably has plenty of bugs that I haven't considered, but it basically works
//the design is a function I read in a blog post by John Resig (http://ejohn.org/blog/javascript-micro-templating/) and it is intended to be loosely translateable to a more comprehensive template language like mustache easily
$.extend({
    quicktmpl: function (template) {
        return new Function("obj", "var p=[],print=function(){p.push.apply(p,arguments);};with(obj){p.push('" + template.replace(/[\r\t\n]/g, " ").split("{{").join("\t").replace(/((^|\}\})[^\t]*)'/g, "$1\r").replace(/\t:(.*?)\}\}/g, "',$1,'").split("\t").join("');").split("}}").join("p.push('").split("\r").join("\\'") + "');}return p.join('');");
}
});

$.extend(Date.prototype, {
    //provides a string that is _year_month_day, intended to be widely usable as a css class
    toDateCssClass: function () {
        return '_' + this.getFullYear() + '_' + (this.getMonth() + 1) + '_' + this.getDate();
},
//this generates a number useful for comparing two dates; 
toDateInt: function () {
        return ((this.getFullYear() * 12) + this.getMonth()) * 32 + this.getDate();
},
toTimeString: function () {
        var hours = this.getHours(),
                minutes = this.getMinutes(),
                hour = (hours > 12) ? (hours - 12) : hours,
                ampm = (hours >= 12) ? ' pm' : ' am';
        if (hours === 0 && minutes === 0) {
            return '';
}
if (minutes > 0) {
            return hour + ':' + minutes + ampm;
}
return hour + ampm;
}
});


(function ($) {
    //t here is a function which gets passed an options object and returns a string of html. I am using quicktmpl to create it based on the template located over in the html block
    var t = $.quicktmpl($('#tmpl').get(0).innerHTML);

    function calendar($el, options) {
        //actions aren't currently in the template, but could be added easily...
        $el.on('click', '.js-cal-prev', function () {
            switch (options.mode) {
                case 'year':
                    options.date.setFullYear(options.date.getFullYear() - 1);
                    break;
                case 'month':
                    options.date.setMonth(options.date.getMonth() - 1);
                    break;
                case 'week':
                    options.date.setDate(options.date.getDate() - 7);
                    break;
                case 'day':
                    options.date.setDate(options.date.getDate() - 1);
                    break;
}
draw();
}).on('click', '.js-cal-next', function () {
            switch (options.mode) {
                case 'year':
                    options.date.setFullYear(options.date.getFullYear() + 1);
                    break;
                case 'month':
                    options.date.setMonth(options.date.getMonth() + 1);
                    break;
                case 'week':
                    options.date.setDate(options.date.getDate() + 7);
                    break;
                case 'day':
                    options.date.setDate(options.date.getDate() + 1);
                    break;
}
draw();
}).on('click', '.js-cal-option', function () {
            var $t = $(this), o = $t.data();
            if (o.date) {
                o.date = new Date(o.date);
}
$.extend(options, o);
draw();
}).on('click', '.js-cal-years', function () {
            var $t = $(this),
                    haspop = $t.data('popover'),
                    s = '',
                    y = options.date.getFullYear() - 2,
                    l = y + 5;
            if (haspop) {
                return true;
}
for (; y < l; y++) {
                s += '<button type="button" class="btn btn-default btn-lg btn-block js-cal-option" data-date="' + (new Date(y, 1, 1)).toISOString() + '" data-mode="year">' + y + '</button>';
}
$t.popover({content: s, html: true, placement: 'auto top'}).popover('toggle');
return false;
}).on('click', '.event', function () {
            var $t = $(this),
                    index = +($t.attr('data-index')),
                    haspop = $t.data('popover'),
                    data, time;

            if (haspop || isNaN(index)) {
                return true;
}
data = options.data[index];
time = convertDate(data.start).toTimeString();
if (time && data.end) {
                time = time + ' - ' + convertDate(data.end).toTimeString();
}
$t.data('popover', true);
$t.popover({content: '<p><strong>' + time + '</strong></p>' + data.text, html: true, placement: 'auto left'}).popover('toggle');
return false;
});
function dayAddEvent(index, event) {
            if (!!event.allDay) {
                monthAddEvent(index, event);
                return;
}
var $event = $('<div/>', {'class': 'event', text: event.title, title: event.title, 'data-index': index}),
start = convertDate(event.start),
end = convertDate(event.end) || convertDate(start),
time = convertDate(event.start).toTimeString(),
hour = start.getHours(),
timeclass = '.time-22-0',
startint = start.toDateInt(),
dateint = options.date.toDateInt(),
endint = end.toDateInt();
console.log(convertDate(event.start));
if (startint > dateint || endint < dateint) {
                return;
}

if (!!time) {
                $event.html('<strong>' + time + '</strong> ' + $event.html());
}
$event.toggleClass('begin', startint === dateint);
$event.toggleClass('end', endint === dateint);
if (hour < 6) {
                timeclass = '.time-0-0';
}
if (hour < 22) {
                timeclass = '.time-' + hour + '-' + (start.getMinutes() < 30 ? '0' : '30');
}
$(timeclass).append($event);
}

function monthAddEvent(index, event) {
            var $event = $('<div/>', {'class': 'event', text: event.title, title: event.title, 'data-index': index}),
e = new Date(event.start),
dateclass = e.toDateCssClass(),
day = $('.' + e.toDateCssClass()),
empty = $('<div/>', {'class': 'clear event', html: ' '}),
numbevents = 0,
time = convertDate(event.start).toTimeString(),
endday = convertDate(event.end) && $('.' + convertDate(event.end).toDateCssClass()).length > 0,
checkanyway = new Date(e.getFullYear(), e.getMonth(), e.getDate() + 40),
existing,
i;
$event.toggleClass('all-day', !!event.allDay);
if (!!time) {
                $event.html('<strong>' + time + '</strong> ' + $event.html());
}
if (!event.end) {
                $event.addClass('begin end');
                $('.' + convertDate(event.start).toDateCssClass()).append($event);
                return;
}

while (e <= convertDate(event.end) && (day.length || endday || options.date < checkanyway)) {
                if (day.length) {
                    existing = day.find('.event').length;
                    numbevents = Math.max(numbevents, existing);
                    for (i = 0; i < numbevents - existing; i++) {
                        day.append(empty.clone());
}
day.append(
$event.
toggleClass('begin', dateclass === convertDate(event.start).toDateCssClass()).
toggleClass('end', dateclass === convertDate(event.end).toDateCssClass())
);
$event = $event.clone();
$event.html(' ');
}
e.setDate(e.getDate() + 1);
dateclass = e.toDateCssClass();
day = $('.' + dateclass);
}
}
function yearAddEvents(events, year) {
            var counts = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
            $.each(events, function (i, v) {
                if (convertDate(v.start).getFullYear() === year) {
                    counts[convertDate(v.start).getMonth()]++;
}
});
$.each(counts, function (i, v) {
                if (v !== 0) {
                    $('.month-' + i).append('<span class="badge">' + v + '</span>');
}
});
}

function draw() {
            $el.html(t(options));
            //potential optimization (untested), this object could be keyed into a dictionary on the dateclass string; the object would need to be reset and the first entry would have to be made here
            $('.' + (new Date()).toDateCssClass()).addClass('today');
            if (options.data && options.data.length) {
                if (options.mode === 'year') {
                    yearAddEvents(options.data, options.date.getFullYear());
} else if (options.mode === 'month' || options.mode === 'week') {
                    $.each(options.data, monthAddEvent);
} else {
                    $.each(options.data, dayAddEvent);
}
}
}
draw();
}

;
(function (defaults, $, window, document) {
        $.extend({
            calendar: function (options) {
                return $.extend(defaults, options);
}
}).fn.extend({
            calendar: function (options) {
                options = $.extend({}, defaults, options);
return $(this).each(function () {
                    var $this = $(this);
                    calendar($this, options);
});
}
});
})({
        days: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
        months: ["January", "February", "March", "April", "May", "June", "Jule", "August", "September", "October", "November", "December"],
        shortMonths: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        date: (new Date()),
        daycss: ["c-sunday", "", "", "", "", "", "c-saturday"],
        todayname: "Today",
        thismonthcss: "current",
        lastmonthcss: "outside",
        nextmonthcss: "outside",
        mode: "month",
        data: []
}, jQuery, window, document);

})(jQuery);

var data;
data = $.ajax({
    url: "events",
    method: "GET",
    dataType: 'json',
    async: false,
    cache: false
}).responseJSON;

console.log(data);

//data must be sorted by start date
data.sort(function (a, b) {
    return (+a.start) - (+b.start);
});

//Actually do everything
$('#holder').calendar({
    data: data
});

function convertDate(date) {
    return (new Date(date));
}
    </script>
</body>

<%@include file = "../common/footer.jsp" %>
</html>