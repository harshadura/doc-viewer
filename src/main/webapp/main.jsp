<html>
<head>
    <script type="text/javascript">
        function validateForm1() {
            var tags = document.getElementById('tags').value;
            if (tags == ''){
               alert("Please mention the TAG name!")
               return false;
            }
            else{
                return true;
            }
        }
    </script>
</head>
<body>
<h2>Doc-Viewer</h2>

<form id='showAll' action='show-docs' method='post'  onsubmit="return validateForm2()" accept-charset='UTF-8'>
    <fieldset >
        <legend>Show All Document</legend>
        <input type='submit' name='submit2' value='Show' />

    </fieldset>
</form>

<form id='login' action='show-docs-bytag' method='post'  onsubmit="return validateForm1()" accept-charset='UTF-8'>
    <fieldset >
        <legend>Search Document</legend>
        <label for='tags' >Search by Tags:</label>
        <input type='text' name='tags' id='tags' maxlength="50" />
        <input type='submit' name='Submit' value='Login' />

    </fieldset>
</form>

</body>
</html>
