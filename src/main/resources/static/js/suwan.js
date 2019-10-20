function GetAge(strBirthday){       
    var returnAge,
        strBirthdayArr=strBirthday.split("-"),
        birthYear = strBirthdayArr[0],
        birthMonth = strBirthdayArr[1],
        birthDay = strBirthdayArr[2],  
        d = new Date(),
        nowYear = d.getFullYear(),
        nowMonth = d.getMonth() + 1,
        nowDay = d.getDate();   
    if(nowYear == birthYear){
        returnAge = 0;//同年 则为0周岁
    }
    else{
        var ageDiff = nowYear - birthYear ; //年之差
        if(ageDiff > 0){
            if(nowMonth == birthMonth) {
                var dayDiff = nowDay - birthDay;//日之差
                if(dayDiff < 0) {
                    returnAge = ageDiff - 1;
                }else {
                    returnAge = ageDiff;
                }
            }else {
                var monthDiff = nowMonth - birthMonth;//月之差
                if(monthDiff < 0) {
                    returnAge = ageDiff - 1;
                }
                else {
                    returnAge = ageDiff ;
                }
            }
        }else {
            returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
        }
    } 
    return returnAge;//返回周岁年龄
}