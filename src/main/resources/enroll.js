
function testUser()
{
    let input = document.getElementById("user");
    let reg = /^[a-zA-Z0-9]{1,10}$/;
    if(!reg.test(input.value)){
        let prompt=document.getElementById("userPrompt");
        prompt.style.visibility = "visible";
        return false;
    }
    else{
        let prompt=document.getElementById("userPrompt");
        prompt.style.visibility = "hidden";
        return true;
    }
}
function testPwd() {
    testRetry();
    let input = document.getElementById("pwd");
    let reg = /^[a-zA-Z0-9]{1,20}$/;
    if(!reg.test(input.value)){
        let prompt=document.getElementById("pwdPrompt");
        prompt.style.visibility = "visible";
        return false;
    }
    else {
        let prompt=document.getElementById("pwdPrompt");
        prompt.style.visibility = "hidden";
        return true;
    }
}
function testRetry() {
    let input = document.getElementById("retry");
    let last = document.getElementById("pwd");
    if(last.value!==input.value){
        let prompt=document.getElementById("retryPrompt");
        prompt.style.visibility = "visible";
        return false;
    }
    else {
        let prompt=document.getElementById("retryPrompt");
        prompt.style.visibility = "hidden";
        return true;
    }
}

function trySubmit() {
    return testUser() && testPwd() && testRetry();
}