<?DOCTYPE HTML>
<html>
<head>
<title>{{ name }}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<!--Bootstrap-->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
</head>

<body>

  <div class="container">

      <div class="masthead">
        <h3 class="muted">Project name</h3>
        <div class="navbar">
          <div class="navbar-inner">
            <div class="container">
              <ul class="nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Downloads</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
              </ul>
            </div>
          </div>
        </div><!-- /.navbar -->
      </div>

<h1>Hello ${name}</h1>


<script src="http://code.jquery.com/jquery.js"/>
<script src="js/bootstrap.min.js"/>
</body>
</html>