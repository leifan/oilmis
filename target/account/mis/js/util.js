/**
 * 
 */

/**字符串判定工具*/
function isBlank(str){
    if(str == undefined || str.replace(/(^\s*)|(\s*$)/g,"").length==0){
        return true;
    }
}