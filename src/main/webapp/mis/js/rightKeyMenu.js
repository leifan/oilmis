/**
 * Created by user on 16/3/6.
 */
jQuery(document).ready(function () {
    $("#oilCanFeedingListTable").mousedown(function (e) {
        if (3 == e.which) {
            document.oncontextmenu = function () {
                return false;
            }
            $("#rightKeyMenu").hide();
            $("#rightKeyMenu").attr("style", "display: block; position: fixed; top:"
                + e.pageY
                + "px; left:"
                + e.pageX
                + "px;");
            $("#rightKeyMenu").show();
        }else{
            $("#rightKeyMenu").hide();
        }
    });

});