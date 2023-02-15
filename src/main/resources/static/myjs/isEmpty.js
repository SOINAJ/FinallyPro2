function isEmpty(str){
    if(str==null||$.trim(str)==""||str=="null"||str.length===0){
        return true;
    }
    return false;
}

function returnEmpty(str){
    if(str==null||str.trim()==""||str=="null"){
        return "";
    }
    return str;
}