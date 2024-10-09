<?php
function encryptData($data, $key) {
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));
    $encrypted = openssl_encrypt($data, 'aes-256-cbc', $key, 0, $iv);
    return base64_encode($encrypted . '::' . $iv);
}

$datainxml = file_get_contents("data.xml");
$key = 'chiave-segreta-123';  // Assicurati di usare una chiave sicura e gestirla in modo sicuro
$cipher = encryptData($datainxml, $key);
echo $cipher;
?>
