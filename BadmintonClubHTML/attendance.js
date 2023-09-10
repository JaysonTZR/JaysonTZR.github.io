function attendance() {
    var attendancecode
    attendancecode = window.prompt("Enter the attendance code: ")
    if (Number.isInteger(parseInt(attendancecode)) == true)
        alert("You have signed the attendance successfully.")
    else
        alert("You have failed to sign the attendance.")
}
