var emailfilter=/^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i

function checkmail(e){
var returnvalue=emailfilter.test(e.value)
if (returnvalue==false){
alert("Please enter a valid email address.")
e.select()
}
else {
    submitmsg()
}
return returnvalue
}

function submitmsg()
{
    window.alert("You have submitted the form.");
}