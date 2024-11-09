$(function () {
    var urls = getAllimgurl();
    changeImg();
    var change = setInterval(function () {
        changeImg();
    }, 9000);
    change;

    function changeImg() {
        urls = addimg();
        var wValue = 1.5 * $(window).width();
        var hValue = 1.5 * $(window).height();
        $("#backgroundimg1").attr("src", urls[0]);
        $("#backgroundimg1").css({
            'width': '100%',
            "position": "fixed",
            "z-index": "-998",
            "left": "0",
            "top": "0",
            "opacity": "1",
            "transition-timing-function":"linear"
        });
        $("#backgroundimg1").stop().animate({
            width: wValue, left: ("-" + (0.5 * $(window).width()) / 2),
            top: ("-" + (0.5 * $(window).height()) / 2), "opacity": "0.8"
        }, 7500).animate({
            width: wValue, left: ("-" + (0.5 * $(window).width()) / 2),
            top: ("-" + (0.5 * $(window).height()) / 2), "opacity": "0"
        }, 1480);
        $("#backgroundimg2").attr("src", urls[1]);
        $("#backgroundimg2").css({'width': '100%', "position": "fixed", "z-index": "-999", "opacity": "1","transition-timing-function":"linear"});
    }

    function addimg() {
        while (urls.length < 4) {
            var imgurl = getImgUrl();
            if (urls.indexOf(imgurl) == -1 && imgurl.length == 25) {
                urls.push(imgurl)
            }
        }
        urls.shift();
        return urls;
    }

    function getImgUrl() {
        var num = Math.floor(Math.random() * 89) + 1;
        var imgNum = "";
        if (null != num && num != '') {
            if (num < 10) {
                imgNum = "00" + num;
            }
            if (num > 10 && num < 100) {
                imgNum = "0" + num;
            }
            if (num > 100) {
                imgNum = "" + num;
            }
            var imgurl = "img/backgroundimg/" + imgNum + ".jpg";
        }
        return imgurl;
    }

    function getAllimgurl() {
        var arr = [];
        while (arr.length < 3) {
            var imgurl = getImgUrl();
            if (arr.indexOf(imgurl) == -1 && imgurl.length == 25) {
                arr.push(imgurl)
            }
        }
        return arr;
    }
})