/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var ws;

function connect() {
    var username = document.getElementById("username").value;
    ws = new WebSocket("ws://" + document.location.host + "/CovidCare_Final/chat/" + username);


    ws.onmessage = function (event) {
        var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
    };
}

function send() {
    var content = document.getElementById("msg").value;
    var to = document.getElementById("to").value;
    var json = JSON.stringify({
        "to": to,
        "content": content
    });

    ws.send(json);
    log.innerHTML += "Me : " + content + "\n";
}