<html>
<head>
    <script type="text/javascript">
        function validateLogin() {
           var username = document.getElementById('username').value;
           var password = document.getElementById('password').value;

            if (username == 'harsha' && password == '123'){
               alert("Welcome to the System!")
               return true;
            }
            else{
                alert("Username or password is not correct!")
                return false;
            }
        }
    </script>
</head>
<body>
<h2>Doc-Viewer</h2>

<form id='showAll' action='show-docs' method='post' accept-charset='UTF-8'>
    <fieldset >
        <legend>Show All Document</legend>
        <input type='submit' name='submit2' value='Show' />

    </fieldset>
</form>

<form id='login' action='' method='post' accept-charset='UTF-8'>
    <fieldset >
        <legend>Search Document</legend>
        <label for='tags' >Search by Tags:</label>
        <input type='text' name='tags' id='tags' maxlength="50" />
        <input type='submit' name='Submit' value='Login' />

    </fieldset>
</form>

</body>
</html>
