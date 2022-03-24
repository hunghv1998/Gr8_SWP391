<%-- 
    Document   : tutorialCovid
    Created on : Feb 23, 2022, 5:29:41 PM
    Author     : Hoang Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html lang="en">
    <% request.setAttribute("title", "HƯỚNG DẪN CHĂM SÓC SỨC KHỎE");%>
    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "../common/nav.jsp" %>

        <!--==================================
        =          Tutorial Covid         =
        ===================================-->

       <section class="dnx_content">
    <div class="dnx_content_inner">
      <div class="dnx_content_box">
        <h2 class="pb-2">HƯỚNG DẪN CHĂM SÓC SỨC KHỎE</h2>
        <div class="qa">
          <div id="accordion">
            <h5 id="qa1" data-toggle="collapse" data-target="#collapse1" aria-expanded="false" aria-controls="collapse1" class="collapsed">
              1. Những Điều cần biết khi phát hiện dương tính COVID-19
            </h5>
            <div id="collapse1" class="collapse" aria-labelledby="qa1" data-parent="#accordion" style="">
              <p><strong>✤ Khi nhận được kết quả xét nghiệm dương tính với SARS-COV-2:</strong><br>
                ♦ Đi thẳng về nhà hoặc nơi lưu trú bằng xe cá nhân, không nên sử dụng các phương tiện giao thông công
                cộng. Luôn đeo khẩu trang y tế trong suốt quá trình di chuyển và giữ khoảng cách an toàn với người
                khác.<br>
                ♦ Khi về đến nhà, chọn nơi tự cách ly phù hợp và bắt đầu cách ly, gọi điện thoại khai báo với Trạm y tế
                hoặc Tổ Covid cộng đồng hoặc trưởng ấp/khu phố, Tổ dân phố/Tổ nhân dân trên địa bàn cư trú để được hướng
                dẫn tiếp theo.
                <br><br>
                <strong>Những điều cần biết khi người F0 cách ly tại nhà:</strong><br>
                <strong>✤ Điều kiện để F0 được cách ly, chăm sóc, điều trị tại nhà:</strong><br>
                Không triệu chứng hoặc triệu chứng mức độ
                nhẹ (không có suy hô hấp: SpO₂ ≥ 97% khi thở khí trời, nhịp thở ≤ 20 lần/phút) VÀ đã tiêm đủ 2 mũi vắc
                xin.<br>
                Lưu ý:<br>
                ♦ Trường hợp chưa tiêm vắc xin thì độ tuổi từ 3 tháng đến 49 tuổi, không có bệnh nền, không đang mang thai,
                không béo phì..<br>
                ♦ Người F0 cách ly tại nhà cần có khả năng tự chăm sóc bản thân. Trường hợp người F0 là trẻ em hoặc
                người không tự chăm sóc cá nhân được thì cần phải có người hỗ trợ chăm sóc.
              </p>
              <div class="row" style="padding: 15px 0 0 0;">
                <div class="col-lg-6 col-md-6 col-sm-6" style="padding: 0 0 0 15px;">
                  <p>
                    <strong>✤ Chuẩn bị vật dụng cần thiết:</strong><br>
                    ♦ Khẩu trang y tế: ít nhất 2 cái/ngày, đủ dùng trong 2-3 tuần;<br>
                    ♦ Có bồn nước rửa tay, xà phòng hoặc dung dịch sát khuẩn tay nhanh;<br>
                    ♦ Dung dịch nước muối sinh lý để súc họng, rửa mũi.<br>
                    ♦ Vật dụng cá nhân dùng riêng cho người F0;<br>
                    ♦ Nhiệt kế, thiết bị đo SpO₂, máy đo huyết áp (nếu có);<br>
                    ♦ Thùng chứa chất thải lây nhiễm có nắp đậy;<br>
                  </p>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6" style="padding: 0 0 0 15px; text-align: center;">
                  <img src="images/hd1.jpg" alt="" style="max-width: 100%;">
                </div>
              </div>
              <p><br>
                <strong>✤ Thuốc điều trị tại nhà:</strong><br>
                ♦ Thuốc điều trị COVID-19: do Trạm y tế cấp phát và sử dụng đúng theo hướng dẫn; trường hợp chưa được
                cấp phát cần liên hệ ngay Trạm y tế.<br>
                ♦ Thuốc đang điều trị bệnh nền (tăng huyết áp, đái tháo đường, tim mạch, hen phế quản…).<br><br>

                <strong>✤ Những điều người F0 nên làm khi cách ly tại nhà:</strong><br>
                ♦ Không bi quan, giữ tâm lý luôn thoải mái. Khi gặp khó khăn, liên hệ bác sĩ để được tư vấn từ xa.<br>
                ♦ Tự theo dõi sức khỏe: đo thân nhiệt, đếm nhịp thở, đo SpO₂ (nếu có) ít nhất hai lần một ngày, hoặc khi
                cảm thấy mệt, khó thở.<br>
                ♦ Khai báo hằng ngày trên hệ thống theo dõi sức khỏe F0 tại nhà theo đường
                link <a href="../landingpage">https://covidcare.com.vn</a>
                hoặc theo mã QR Code: …<br>
                ♦ Mang khẩu trang liên tục, rửa tay hoặc sát khuẩn tay thường xuyên.<br>
                ♦ Rửa mũi, súc họng hàng ngày bằng nước muối sinh lý.<br>
                ♦ Thường xuyên tập thở, vận động nâng cao sức khỏe.<br>
                ♦ Uống đủ nước hoặc nhiều hơn nếu có sốt, tiêu chảy. Không bỏ bữa, tăng cường dinh dưỡng, ăn uống đủ
                chất, tăng cường trái cây tươi, rau xanh.<br>
                ♦ Nơi cách ly phải thông thoáng, không sử dụng máy lạnh trung tâm; thường xuyên làm vệ sinh các bề mặt,
                vật dụng, nhà vệ sinh.<br>
              </p>
              <div class="row" style="padding: 15px 0 0 0;">
                <div class="col-lg-6 col-md-6 col-sm-6" style="padding: 0 0 0 15px;">
                  <p>
                    <strong>✤ Những điều KHÔNG nên làm:</strong><br>
                    ♦ KHÔNG tự ý rời khỏi nơi cách ly.<br>
                    ♦ KHÔNG sử dụng chung vật dụng với người khác.<br>
                    ♦ KHÔNG ăn uống cùng với người khác.<br>
                    ♦ KHÔNG tiếp xúc gần với người khác hoặc vật nuôi.<br>
                    Trường hợp cần có người chăm sóc, người chăm sóc phải đeo khẩu trang,
                    kính chắn giọt bắn, rửa tay/sát khuẩn tay trước và sau khi chăm sóc.<br>
                  </p>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6" style="padding: 0 0 0 15px; text-align: center">
                  <img src="images/hd2.jpg" alt="" style="max-width: 100%;">
                </div>
              </div>
              <p><br>
                <strong>✤ Các dấu hiệu cần báo ngay cho y tế địa phương</strong><br>
                ♦ Khó thở, thở hụt hơi, hoặc ở trẻ em có dấu hiệu thở bất thường: thở rên, rút lõm lồng ngực, phập phồng
                cánh mũi, khò khè, thở rít thì hít vào.<br>
                ♦ Nhịp thở tăng: ≥ 21 lần/phút đối với người lớn; ≥ 40 lần/phút đối với trẻ từ 1 đến dưới 5 tuổi; ≥ 30
                lần/phút đối với trẻ từ 5 đến dưới 12 tuổi.<br>
                ♦ SpO₂ ≤ 95% (nếu có).<br>
                ♦ Mạch nhanh &gt; 120 nhịp/phút hoặc dưới 50 lần/phút.<br>
                ♦ Huyết áp thấp: huyết áp tối đa &lt; 90 mmHg, huyết áp tối thiểu &lt; 60 mmHg (nếu có).<br>
                ♦ Đau tức ngực thường xuyên, cảm giác bó thắt ngực, đau tăng khi hít sâu.<br>
                ♦ Thay đổi ý thức: Lú lẫn, ngủ rũ, lơ mơ, rất mệt/mệt lả, trẻ quấy khóc, li bì khó đánh thức, co
                  giật.<br>
                  ♦ Tím môi, tím đầu móng tay, móng chân, da xanh, môi nhợt, lạnh đầu ngón tay, ngón chân.<br>
                  ♦ Không thể uống. Trẻ em bú kém/giảm, ăn kém, nôn.<br>
                  ♦ Trẻ có biểu hiện: Sốt cao, đỏ mắt, môi đỏ, lưỡi đỏ, ngón tay chân sưng phù nổi ban đỏ, nốt hoặc mảng
                  xuất huyết...
              </p>

            </div>

            <h5 id="qa2" class="collapsed" data-toggle="collapse" data-target="#collapse2" aria-expanded="false" aria-controls="collapse2">
              2. Hướng dẫn xử lý một số triệu chứng thông thường</h5>
            <div id="collapse2" class="collapse" aria-labelledby="qa2" data-parent="#accordion">
              <p>
                <strong>✤ Nếu sốt:</strong><br>
                ✸ Đối với người lớn: &gt; 38.5 độ hoặc đau đầu, đau người nhiều: uống mỗi lần 1 viên thuốc hạ sốt
                (paracetamol) 0,5g, có thể lặp lại mỗi 4-6h, ngày không quá 4 viên, uống oresol nếu uống kém/giảm hoặc
                có thể dùng uống thay nước.<br>
                ✸ Đối với trẻ em: &gt; 38.50 C, uống thuốc hạ sốt như Paracetamol liều 10 - 15mg/kg/lần, có thể lặp lại mỗi
                4-6 giờ, ngày không quá 4 lần.<br><br>
              </p>
              <table class="table table-bordered">
                <tbody>
                  <tr>
                    <td><strong>Độ tuổi trẻ em</strong></td>
                    <td><strong>Dạng thuốc</strong></td>
                    <td><strong>Liều thuốc tối đa mỗi ngày</strong></td>
                  </tr>
                  <tr>
                    <td>
                      &lt; 1 tuổi </td>
                    <td>Paracetamol bột 80mg
                    </td>
                    <td>1 gói x 4 lần/ ngày
                    </td>
                  </tr>
                  <tr>
                    <td>
                      ( 1 đến dưới 2 tuổi)</td>
                    <td>
                      Paracetamol bột 150mg</td>
                    <td>
                      1 gói x 4 lần/ ngày</td>
                  </tr>
                  <tr>
                    <td>
                      ( 2 đến dưới 5 tuổi)</td>
                    <td>
                      Paracetamol bột 250mg</td>
                    <td>
                      1 gói x 4 lần / ngày</td>
                  </tr>
                  <tr>
                    <td>
                      ( 5 đến 12 tuổi)</td>
                    <td>
                      Paracetamol viên 325mg</td>
                    <td>
                      1 viên x 4 lần/ ngày</td>
                  </tr>
                  <tr>
                    <td>
                      Trên 12 tuổi</td>
                    <td>
                      Paracetamol viên 500mg</td>
                    <td>
                      1 viên x 4 lần/ ngày</td>
                  </tr>
                </tbody>
              </table>
              <p><br>
                <strong>✤ Nếu ho: </strong>dùng thuốc giảm ho theo đơn, hoặc các thuốc giảm ho có thành phần thảo dược
                <br><br>
                <strong>✤ Căng thẳng tinh thần: </strong><br>
                <strong>✤ Cách ứng phó với căng thẳng tinh thần</strong><br>
                ✸ Tránh xem, đọc hoặc nghe những câu chuyện tin tức về dịch COVID-19, nhất là trên các mạng xã hội:
                zalo, facebook, youtube, tiktok…<br>
                ✸ Chăm sóc cơ thể và sức khỏe tinh thần của bản thân:<br>
                ♦ Hít thở sâu hoặc thực hành thiền.<br>
                ♦ Cố gắng ăn uống lành mạnh, cân bằng dinh dưỡng.<br>
                ♦ Tập thể dục tại chỗ thường xuyên, vừa sức, không thức khuya.<br>
                ♦ Tránh sử dụng rượu/bia, thuốc lá, ma túy, các loại thức ăn nước uống có chất kích thích.<br>
                ✸ Dành thời gian nghỉ ngơi thư giãn. Cố gắng thực hiện một vài hoạt động mà bản thân yêu thích như: đọc
                sách, vẽ, xem phim, nghe nhạc, làm mô hình, nấu ăn (nếu có thể)…<br>
                ✸ Tăng cường giao tiếp, kết nối với những người khác. Tâm sự về những lo lắng.<br>
                ✸ Kết nối với các tổ chức cộng đồng hoặc tôn giáo hoặc nhóm diễn đàn xã hội.<br>
                ✸ Thừa nhận là việc căng thẳng cũng không sao, không có gì là xấu hổ khi nhờ người khác giúp đỡ.<br>
              </p>
            </div>

            <h5 id="qa3" class="collapsed" data-toggle="collapse" data-target="#collapse3" aria-expanded="false" aria-controls="collapse3">
              3. Hướng dẫn tập thở
            </h5>
            <div id="collapse3" class="collapse" aria-labelledby="qa3" data-parent="#accordion">
              <p>
                Người nhiễm COVID-19 ngoài chăm sóc, dinh dưỡng hợp lý, cần tập luyện tăng cường chức năng hô hấp và vận
                động hàng ngày với tinh thần lạc quan để cải thiện sức khỏe. Tập luyện, vận động trong giai đoạn này
                giúp:<br>
                ✸ Giãn nở lồng ngực, tăng thông khí ra vào phổi, hô hấp tốt hơn.<br>
                ✸ Tăng thải đờm.<br>
                ✸ Tăng cường khả năng vận động và các cơ tham gia hô hấp.<br>
                ✸ Ngăn chặn suy giảm thể chất, cải thiện tinh thần.<br><br>
                <strong>✤ Một số bài tập thở, vận động gồm:</strong><br>
                Các bài tập thở
              </p>
              <div style="padding: 0 0 0 15px; text-align: center">
                <img src="images/tap_tho1.jpg" alt="" style="max-width: 100%;">
              </div>
              <p>
                <strong>✤ Bài tập thở giúp giảm khó thở</strong><br>
                <strong>✤ Bài tập thở mím môi:</strong><br>
                ✸ Ngồi thẳng lưng hoặc hơi ngả ra sau, thư giãn cổ và vai.<br>
                ✸ Hít vào chỉ bằng mũi trong 2 giây, như thể đang ngửi một bông hoa.<br>
                ✸ Thở ra từ từ (trong 4 giây nếu có thể) bằng cách mím môi, như đang thổi nến sinh nhật.<br>
                ✸ Lặp lại chu kỳ hít vào và thở ra trong 2 phút, vài lần mỗi ngày và khi cần thiết.<br>
                <strong>✤ Bài tập thở sâu:</strong><br>
                ✸ Ngả người trên giường hoặc trên ghế sofa với một chiếc gối kê dưới đầu và đầu gối của bạn. Nếu không
                thể ngả lưng, có thể thực hiện thao tác này khi ngồi thẳng lưng.<br>
                ✸ Đặt một tay lên bụng, tay kia đặt trên ngực.<br>
                ✸ Từ từ hít vào bằng mũi; để phổi của bạn được lấp đầy không khí, cho phép bụng của bạn căng lên. (Bàn
                tay trên bụng nên di chuyển nhiều hơn tay trên ngực.)<br>
                ✸ Thở ra bằng mũi và khi bạn thở ra, cảm thấy bụng của bạn lõm sâu hơn.<br>
                ✸ Lặp lại chu kỳ hít vào và thở ra từ 2 đến 5 phút vài lần mỗi ngày và khi cần thiết.<br>
                TLTK<br>
                1. American Lung Association. Breathing exercises. Available at: <a href="https://www.lung.org/lung-health-diseases/wellness/breathing-exercises">https://www.lung.org/lung-health-diseases/wellness/breathing-exercises</a><br><br>
                <strong>✤ Một số tư thế giúp bạn dễ thở hơn</strong><br>
                Sau đây là một vài tư thế giúp cải thiện tình trạng khó thở của bạn. Hãy nhớ, khi có tình trạng khó thở,
                liên hệ ngay với trung tâm y tế gần nhất để được hỗ trợ
              </p>
              <div style="padding: 0 0 0 15px; text-align: center">
                <img src="images/tap_tho2.jpg" alt="" style="max-width: 100%;">
              </div>
              <p style="text-align: center; padding: 10px 0 20px;">1. Nằm nghiêng 1 bên, kê cao đầu</p>
              <div style="padding: 0 0 0 15px; text-align: center">
                <img src="images/tap_tho3.jpg" alt="" style="max-width: 100%;">
              </div>
              <p style="text-align: center; padding: 10px 0 20px;">2. Ngồi vào bàn, với cánh tay và gối đặt trên bàn</p>

              <div style="padding: 0 0 0 15px; text-align: center">
                <img src="images/tap_tho4.jpg" alt="" style="max-width: 100%;">
              </div>
              <p style="text-align: center; padding: 10px 0 20px;">3. Ngồi trên ghế, nghiêng người phía trước, đặt tay
                trên đùi. </p>
              <div style="padding: 0 0 0 15px; text-align: center">
                <img src="images/tap_tho5.jpg" alt="" style="max-width: 100%;">
              </div>
              <p style="text-align: center; padding: 10px 0 20px;">4. Đứng nghiêng người về phía trước</p>
              <div style="padding: 0 0 0 15px; text-align: center">
                <img src="images/tap_tho6.jpg" alt="" style="max-width: 100%;">
              </div>
              <p style="text-align: center; padding: 10px 0 20px;">5. Đứng dựa lưng vào tường</p>
            </div>

            <h5 id="qa4" class="collapsed" data-toggle="collapse" data-target="#collapse4" aria-expanded="false" aria-controls="collapse4">
              4. Dinh dưỡng cho bệnh nhân COVID-19
            </h5>
            <div id="collapse4" class="collapse" aria-labelledby="qa4" data-parent="#accordion">
              <p>
                <strong>1. Nguyên tắc chung về chế độ dinh dưỡng cho người nhiễm COVID-19 mức độ nhẹ và không có triệu
                  chứng</strong><br>
                ♦ Ăn bình thường với đầy đủ và cân đối các nhóm chất dinh dưỡng, đa dạng loại thực phẩm (nếu được) để
                duy trì thể trạng, thể chất bình thường<br>
                ♦ Bổ sung thêm 1 đến 2 bữa phụ như sữa và các chế phẩm từ sữa, đặc biệt khi có ăn giảm sút do sốt, ho,
                mệt mỏi...<br>
                ♦ Ăn tăng cường nhóm thực phẩm giàu protein (thịt, cá nạc.., đậu đỗ, hạt các loại) để ngăn ngừa teo cơ
                và tăng sức đề kháng.<br>
                ♦ Ăn tăng cường trái cây tươi hoặc nước ép trái cây, rau xanh các loại, gia vị (như tỏi, gừng) để tăng
                cường sức đề kháng.<br>
                ♦ Uống đủ nước (trung bình 2 lít/ ngày) hoặc nhiều hơn nếu có sốt, tiêu chảy.
                <br><br>

                <strong>2. Dinh dưỡng đầy đủ và cân đối</strong><br>
                ♦ Đảm bảo đủ các và đa dạng các nhóm thực phẩm bao gồm: nhóm tinh bột, nhóm sữa và chế phẩm sữa, nhóm
                dầu mỡ, nhóm rau củ, nhóm thịt cá, nhóm trứng, nhóm các loại hạt, nhóm rau củ màu vàng-xanh thẫm.<br>
                ♦ Không bỏ bữa: Ăn đủ 3 bữa chính và tăng cường thêm các bữa phụdinh dưỡng<br>
                ♦ Hạn chế ăn quá nhiều đồ ngọt (khuyến nghị lượng đường &lt; 10% tổng năng lượng ăn vào).<br>
                  ♦ Không kiêng khem
                  thực phẩm nếu không có dị ứng thực phẩm hoặc theo lời khuyên riêng của bác sỹ. <br>
                  ♦ Người có thể trạng
                  gầy, trẻ em cần bổ sung thêm các thực phẩm có nhiều năng lượng và protein như sữa và các sản phẩm từ
                  sữa. <br><br>

                  <i>Cụ thể<br>
                    ♦ Năng lượng 30 - 35 kcal/kg cân nặng/ngày, chất đạm 15-20% tổng năng lượng, nhu cầu chất béo 20-25%
                    tổng năng lượng, chất đường bột 50 -65% tổng năng lượng.<br>
                    ♦ Cung cấp đầy đủ vitamin và khoáng chất theo lứa tuổi. Đặc biệt tăng cường các thực phẩm giàu
                    vitamin
                    A, C, D, E; các thực phẩm giàu kẽm và selen. Rau xanh 300g/ngày, hoa quả 200g/ngày.<br>
                    ♦ Chất xơ cung cấp 18-20g/ ngày.<br>
                    ♦ Muối 5g/ngày.<br>
                    ♦ Uống nhiều nước (40-45ml/kg cân nặng/ngày), nên uống nước ấm và rải rác trong ngày, tránh tình
                    trạng
                    chỉ uống khi thấy khát, nên uống nước lọc, nước ép hoa quả. Người bệnh có sốt nên uống Orezol để bù
                    nước và điện giải</i><br><br>

                  <strong>3. Dinh dưỡng an toàn</strong><br>
                  ♦ Tránh đồ ăn, uống có nhiều đường, nhiều muối, rượu, bia.<br>
                  ♦ Thực phẩm phải bảo đảm an toàn, vệ sinh. Không dùng thực phẩm ôi, thiu, quá hạn sử dụng.<br>
                  ♦ Bảo đảm vệ sinh khi chế biến thực phẩm. Luôn rửa tay trước và sau khi chế biến thực phẩm.<br>
                  ♦ Sử dụng các sản phẩm dinh dưỡng bổ sung cần theo hướng dẫn của chuyên gia dinh dưỡng.
                  <br><br>
                  <strong>4. Lựa chọn thực phẩm</strong><br><br>
              </p>
              <table class="table table-bordered">
                <tbody>
                  <tr>
                    <td><strong>Thực phẩm nên dùng</strong></td>
                    <td><strong>Thực phẩm hạn chế dùng</strong></td>
                  </tr>
                  <tr>
                    
                    <td>♦ Gạo, mỳ, ngô, khoai, sắn,…<br>
                      ♦ Các loại hạt: đậu đỗ, vừng, lạc…<br>
                      ♦ Sữa và các sản phẩm từ sữa: sữa bột, sữa tươi, sữa chua…<br>
                      ♦ Thịt các loại, cá, tôm…<br>
                      ♦ Trứng và các sản phẩm từ trứng: trứng gà, trứng vịt, trứng chim cút…<br>
                      ♦ Dầu thực vật, dầu oliu, dầu cá,…<br>
                      ♦ Các loại rau: đa dạng các loại rau.<br>
                      ♦ Quả tươi: ăn đa dạng các loại quả
                    </td>
                    <td> ♦Mỡ động vật, phủ tạng động vật.<br>
                      ♦ Các thực phẩm chứa nhiều muối (đồ hộp, dưa muối, cà muối...).<br>
                      ♦ Các loại nước ngọt có ga, bánh kẹo ngọt.<br>
                      ♦ Các chất kích thích như: rượu, bia, cà phê, thuốc lá
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>

            <h5 id="qa5" class="collapsed" data-toggle="collapse" data-target="#collapse5" aria-expanded="false" aria-controls="collapse5">
              5. Lời khuyên cho 1 số đối tượng đặc biệt
            </h5>
            <div id="collapse5" class="collapse" aria-labelledby="qa5" data-parent="#accordion">
              <p>
                <strong>✤ Lời khuyên đối với người khuyết tật</strong><br>
                ✸ Người khuyết tật nhiễm COVID-19, ngoài việc cần chăm sóc như mọi người khác, thì cần được quan tâm,
                chăm sóc đặc biệt, nhất là với người có khó khăn trong tự phục vụ sinh hoạt hàng ngày...<br>
                ✸ Hãy mạnh mẽ và tự tin vào bản thân, chúng ta sẽ vượt qua đại dịch khi có kiến thức về phòng chống dịch
                COVID-19 và cách ly y tế, điều trị tại nhà.<br>
                ✸ Người khuyết tật có nguy cơ mắc bệnh COVID-19 với mức độ nặng cao hơn, vì vậy, người chăm sóc thường
                sẵn sàng các tình huống phải liên lạc với nhân viên y tế; theo dõi sát dấu hiệu của người nhiễm và cần
                chuyển cấp cứu kịp thời tại các cơ sở y tế điều trị COVID-19 trên địa bàn khi có các dấu hiệu cảnh báo
                khẩn cấp.<br>
                ✸ Kết hợp các hoạt động luyện tập phục hồi chức năng, tăng cường sức khỏe thể chất, tinh thần để giúp bù
                đắp cho việc hạn chế các hoạt động bên ngoài và tình trạng căng thẳng, lo lắng, trầm cảm, thất vọng.<br>
                ✸ Thường xuyên vệ sinh, khử khuẩn dụng cụ trợ giúp người khuyết tật trước và sau khi sử dụng.
                <br><br>

                <strong>✤ Lời khuyên đối với người cao tuổi</strong><br>
                ✸ Người cao tuổi có nguy cơ mắc tình trạng nghiêm trọng khi mắc COVID-19 cao hơn các lứa tuổi khác. Tuổi
                càng cao, nguy cơ mắc bệnh mức độ nặng càng cao.<br>
                ✸ Người cao tuổi và người chăm sóc cần biết, theo dõi để phòng tránh nguy cơ diễn biến nặng và cần
                chuyển cấp cứu kịp thời tại bệnh viện trên địa bàn khi có các dấu hiệu cảnh báo khẩn cấp.<br>
                ✸ Thực hiện chế độ ăn đủ dinh dưỡng (1.700-1.900 Kcal/ngày), cân đối, lành mạnh, nhiều rau xanh. Đảm bảo
                ăn 3-4 bữa mỗi ngày, nếu ăn không đủ nên uống thêm các loại sữa bổ sung dinh dưỡng, từ 1-2 cốc mỗi
                ngày.<br>
                ✸ Cần thực hiện nghiêm ngặt chế độ dinh dưỡng bệnh lý và sử dụng thuốc đang điều trị bệnh sẵn có theo
                chỉ định của bác sĩ điều trị (không bỏ thuốc).<br>
                ✸ Tăng cường luyện tập tại phòng cách ly, trên giường tục theo điều kiện bằng các bài tập phục hồi chức
                năng, xoa bóp, hỗ trợ tập luyện để nâng cao sức khỏe.
                <br><br>

                <strong>✤ Đối với trẻ em </strong><br>
                * Cha mẹ hãy bình tĩnh nếu con mình nhiễm COVID-19 và tự tin vào khả năng chăm sóc trẻ khi trẻ
                nhiễm.<br>
                ✸ Tâm sự, trấn an con về dịch COVID-19.<br>
                ✸ Giải đáp thắc mắc và chia sẻ thông tin thực tế về dịch COVID-19. Trẻ có thể hiểu sai thông tin và có
                thể hoảng sợ.<br>
                ✸ Hạn chế gia đình tiếp xúc và nói chuyện về tin tức, sự kiện về COVID-19 có thể gây hoang mang, sợ
                hãi.<br>
                ✸ Cố gắng duy trì những thói quen bình thường, sinh hoạt khoa học. Lập thời gian biểu cho các hoạt động
                học tập và nghỉ ngơi hoặc các hoạt động giải trí.<br>
                ✸ Hướng dẫn trẻ các hành động hàng ngày để giảm sự lây lan của mầm bệnh như: rửa tay thường xuyên; sử
                dụng khăn giấy hoặc khuỷu tay khi ho hoặc hắt hơi, sau đó vứt khăn giấy vào thùng đựng chất thải.<br>
                ✸ Tạo điều kiện cho trẻ tham gia các hoạt động giải trí trong phòng cách ly phù hợp như các trò chơi
                online hay cùng chơi với bố, mẹ…
                <br><br>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section> 
        
        
        
        
        
 </body>

    <%@include file = "../common/footer.jsp" %>
</html>