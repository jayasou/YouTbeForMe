<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Home</title>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>

    function print(data) {
        alert('에?!');
        var tbody = $('#tbody');
        $(data).each(function () {
            var tr = $('<tr></tr>');

            var td = $('<td></td>');
            var td2 = $('<td></td>');
            var td3 = $('<td></td>');
             var p = $('<p></p>').text(this.title);
             var p2 = $('<p></p>').text(this.duration);
             var p3 = $('<p></p>').text(this.format);



             td.append(p);
             tr.append(td);

             td2.append(p2);
             tr.append(td2);

             td3.append(p3);
             tr.append(td3);
             tbody.append(tr);
        });

    }

    function ajaxSubmit(actURL,params) {
        $.ajax({
            url : actURL  ,type : 'POST' ,dataType : 'json' , data : {param : JSON.stringify(params) },
            beforeSend : function(data){
                console.log("ajaxSubmit.params = " + data);

                $('.wrap-loading').show();
                $('.wrap-loading').css('zIndex',100);
            },
            success : function(data){
                $('.wrap-loading').hide();
                $('.wrap-loading').css('zIndex',-100);
                console.log(data);
                print(data);

            }
            ,error : function(request, status, error){
                $('.wrap-loading').hide();
                $('.wrap-loading').css('zIndex',-100);
                alert("자료 처리중 오류가 발생하였습니다.\n응답코드 = " + request.status);
                alert("Error:\n\t" + error.message + "\nLine:\n\t" + error.lineno + "\nFile:\n\t" + error.filename);
            }
        });
    }

    $(document).ready(function() {

        var showBtn = $('#showList');
        showBtn.click(function() {
            var youtubeUrl = $('#url').val();
console.log(youtubeUrl);



           ajaxSubmit("/getVideoList", youtubeUrl);
        });
    });

</script>
<body>
<p>https://www.youtube.com/playlist?list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I</p>
<div>
 <input type="text" id="url" class="url" name="url"/>
    <input type="button" id="showList" />
</div>


<div>
    <table>
        <thead>
        <tr>
            <th>TITLE</th>
            <th>DURATION</th>
            <th>FORMAT</th>
        </tr>
        </thead>

        <tbody id="tbody" class="tbody" name="tbody">
            <tr><td><p id="pid">Hello ~~~ </p></td></tr>
        </tbody>
    </table>
</div>



</body>
</html>
