<?php

if (!function_exists('text_to_url')) {
    function text_to_url($text) {
        return preg_replace(
            '/^-+|-+$/'
            , '', strtolower(preg_replace('/[^a-zA-Z0-9]+/', '-', $text))
        );
    }
}