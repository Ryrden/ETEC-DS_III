<?php
class conexaoBD{
    private $serverName = "localhost"
    private $userName = "root";
    private $password = "usbw";
    private $dbName = "projeto final";

    public function conectar(){
        $conn = new mysqli($this->serverName, $this->userName, $this->password, $this->dbName);
        return $conn;
    }
}
?>