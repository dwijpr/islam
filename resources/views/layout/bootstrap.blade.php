<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--
            The above 3 meta tags *must* come first in the head; any other head
            content must come *after* these tags
        -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="{{ asset('/img/favicon.png') }}">
        <title>Fixed Top Navbar Example for Bootstrap</title>
        <!-- Bootstrap core CSS -->
        {{ Html::style('/bootstrap/3.3.7/dist/css/bootstrap.css') }}
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        {{ Html::style(
            '/bootstrap/3.3.7/assets/css/ie10-viewport-bug-workaround.css'
        ) }}
        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]>{{ Html::script(
            "/bootstrap/3.3.7/assets/js/ie8-responsive-file-warning.js"
        ) }}<![endif]-->
        {{ Html::script(
            '/bootstrap/3.3.7/assets/js/ie-emulation-modes-warning.js'
        ) }}
        <!--
            HTML5 shim and Respond.js for IE8 support of HTML5 elements and
            media queries
        -->
        <!--[if lt IE 9]>
        {{ Html::script('/html5shiv/3.7.3/html5shiv.min.js') }}
        {{ Html::script('/respond/1.4.2/respond.min.js') }}
        <![endif]-->
        <style>
            body {
                padding-top: 72px;
                padding-bottom: 72px;
            }

            @font-face {
                font-family: Mirza;
                src: url('{{ asset('/font/Mirza-Regular.ttf') }}');
            }

            .ar {
                font-family: Mirza;
                font-size: 48px;
                text-align: right;
            }
        </style>
    </head>
    <body>
        <!-- Fixed navbar -->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button
                        type="button"
                        class="navbar-toggle collapsed"
                        data-toggle="collapse"
                        data-target="#navbar"
                        aria-expanded="false"
                        aria-controls="navbar"
                    >
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="{{ url('/') }}">
                        {{ config('app.name.en') }}
                        <span class="ar" style="font-size: 24px;">
                            {{ config('app.name.ar') }}
                        </span>
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                        <li class="dropdown">
                            <a
                                href="#"
                                class="dropdown-toggle"
                                data-toggle="dropdown"
                                role="button"
                                aria-haspopup="true"
                                aria-expanded="false"
                            >Dropdown <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Nav header</li>
                                <li><a href="#">Separated link</a></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="../navbar/">Default</a></li>
                        <li><a href="../navbar-static-top/">Static top</a></li>
                        <li class="active">
                            <a href="./">
                                Fixed top <span class="sr-only">(current)</span>
                            </a>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        @yield('content')
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        {{ Html::script('/ajax/libs/jquery/1.12.4/jquery.min.js') }}
        <script>
            window.jQuery || document.write(
                '<script src="../../assets/js/vendor/jquery.min.js"><\/script>'
            )
        </script>
        {{ Html::script('/bootstrap/3.3.7/dist/js/bootstrap.js') }}
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        {{ Html::script(
            '/bootstrap/3.3.7/assets/js/ie10-viewport-bug-workaround.js'
        ) }}
    </body>
</html>
