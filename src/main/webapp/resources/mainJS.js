function getVideoInfoList() {
    var inputURL = $('#query').val();

    $.ajax({
        type: "POST",
        url : "/youtubedl/getVideoList",
        data : {url : inputURL},
        success: function(data) {
            console.log(JSON.stringify(data));
            print(data);
        },
        error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
}

$('.actions').on("click", function(e){
    getVideoInfoList();
})


function print(data) {
    $(data).each(function () {
        var content = $('#content');
        var div9_12 = $('<div></div>').addClass('9u 12u$(medium)');
        var divBox = $('<div></div>').addClass('box');
        var divFlex = $('<div></div>').addClass('flex flex-2');
        var divCol2 = $('<div></div>').addClass('col col2');

        var h3 = $('<h3></h3>').append(this.title);
        var p = $('<p></p>').append(this.description);
        var input = $('<input></input>').attr('type', 'checkbox')
            .attr('id', this.id).attr('name', this.id);
        var label = $('<label></label>').attr('for', this.id).append('I GOT IT');

        divCol2.append(h3);
        divCol2.append(p);
        divCol2.append(input);
        divCol2.append(label);

        var divCol1 = $('<div></div>').addClass('col col1 first');
        var divImg = $('<div></div>').addClass('image round fit');
        var aHref = $('<a></a>').addClass('link').attr('href', this.thumbnail);
        var img = $('<img></img>').attr('src', this.thumbnail);

        aHref.append(img);
        divImg.append(aHref);
        divCol1.append(divImg);

        divFlex.append(divCol2);
        divFlex.append(divCol1);

        divBox.append(divFlex);
        div9_12.append(divBox);
        content.append(div9_12);
    });

}