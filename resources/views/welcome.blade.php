<!DOCTYPE html>
<html lang="{{ config('app.locale') }}">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>
            {{ config('app.name.en') }}
            {{ config('app.name.ar') }}
        </title>

        <!-- Fonts -->
        <?php
            $raleway = [
                '100' => 'Thin',
                '200' => 'ExtraLight',
                '300' => 'Light',
                '400' => [
                    'normal' => 'Regular',
                    'italic' => 'Italic',
                ],
                '500' => 'Medium',
                '600' => 'SemiBold',
                '700' => 'Bold',
                '800' => 'ExtraBold',
                '900' => 'Black',
            ];
        ?>
        <style>
        @foreach ($raleway as $weight => $font)
            <?php
                $_font = is_array($font)?$font['normal']:$font;
                $_fontItalic = is_array($font)?$font['italic']:($font.'Italic');
            ?>
            @font-face {
                font-family: 'Raleway';
                src: url({{ asset(
                    '/font/Raleway/Raleway-'.$_font.'.ttf'
                ) }});
                font-weight: {{ $weight }};
            }
            @font-face {
                font-family: 'Raleway';
                src: url({{ asset(
                    '/font/Raleway/Raleway-'.$_fontItalic.'.ttf'
                ) }});
                font-weight: {{ $weight }};
                font-style: italic;
            }
        @endforeach
        </style>

        <!-- Styles -->
        <style>
            html, body {
                background-color: #fff;
                color: #636b6f;
                font-family: 'Raleway', sans-serif;
                font-weight: 100;
                height: 100vh;
                margin: 0;
            }

            .full-height {
                height: 100vh;
            }

            .flex-center {
                align-items: center;
                display: flex;
                justify-content: center;
            }

            .position-ref {
                position: relative;
            }

            .top-right {
                position: absolute;
                right: 10px;
                top: 18px;
            }

            .content {
                text-align: center;
            }

            .title {
                font-size: 84px;
            }

            .links > a {
                color: #636b6f;
                padding: 0 25px;
                font-size: 12px;
                font-weight: 600;
                letter-spacing: .1rem;
                text-decoration: none;
                text-transform: uppercase;
            }

            .m-b-md {
                margin-bottom: 30px;
            }

            @font-face {
                font-family: QalamMajeed;
                src: url('{{ asset('/font/qalam_majeed.ttf') }}');
            }

            .ar {
                font-family: QalamMajeed;
                text-align: right;
            }
        </style>
    </head>
    <body>
        <div class="flex-center position-ref full-height">
            @if (Route::has('login'))
                <div class="top-right links">
                    @if (Auth::check())
                        <a href="{{ url('/home') }}">Home</a>
                    @else
                        <a href="{{ url('/login') }}">Login</a>
                        <a href="{{ url('/register') }}">Register</a>
                    @endif
                </div>
            @endif

            <div class="content">
                <div class="title m-b-md">
                    {{ config('app.name.en') }}
                    <span class="ar">
                        {{ config('app.name.ar') }}
                    </span>
                </div>

                <div class="links">
                    <a href="{{ url('/quran/progress') }}">Quran</a>
                    <a href="javascript:">Sunnah</a>
                </div>
            </div>
        </div>
    </body>
</html>
