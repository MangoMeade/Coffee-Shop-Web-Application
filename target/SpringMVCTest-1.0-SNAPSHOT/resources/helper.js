function checkForm(form)
{
    if(form.password.value != "" && form.pw_veri.value == form.password.value) {
        if(form.password.value.length < 6) {
            alert("Error: Password must contain at least six characters!");
            form.password.focus();
            return false;
        }
    } else {
        alert("Error: Your passwords do not match!");
        form.password.focus();
        return false;
    }
    return true;
}