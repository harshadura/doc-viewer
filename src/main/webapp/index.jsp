<html>
<head>
    <script type="text/javascript">
        function validateForm() {
           var username = document.getElementById('username').value;
           var password = document.getElementById('password').value;

            if (username == 'harsha' && password == '123'){
               alert("Welcome to the System!");
               return true;
            }
            else{
                alert("Username or password is not correct!");
                return false;
            }
        }
    </script>
</head>
<body>
<h2>Welcome to Doc-Viewer!</h2>

<form id='login' action='main.jsp' method='post' onsubmit="return validateForm()" accept-charset='UTF-8'>
    <fieldset >
        <legend>Register</legend>
        <label for='username' >UserName*:</label>
        <input type='text' name='username' id='username' maxlength="50" />  <br/><br/>

        <label for='password' >Pass word*:</label>
        <input type='password' name='password' id='password' maxlength="50" />  <br/><br/>
        <input type='submit' name='Submit' value='Login' />

    </fieldset>
</form>

</body>
</html>
