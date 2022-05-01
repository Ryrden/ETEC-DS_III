<?php  
class usuario {
    private $id;
    private $nome;
    private $cpf;
    private $email;
    private $dataNascimento;
    private $senha;

    public function inserirBD(){
        require_once 'ConexaoBD.php'
        
        $con = new conexaoBD;
        $conn = $con->conectar();

        if ($conn->connect error)
            die("Connection failed: ". $conn->connect error);
        
        $sql = "INSERT INTO usuario (nome,cpf,email,senha)
        VALUES ('".$this->nome."','".$this->cpf."','".$this->email."','."$this->senha.")";

        if ($conn->query($sql) === TRUE){
            $this->id = mysqli insert id($conn);
            $conn->close();
            return TRUE;
        }
        $conn->close();
        return FALSE;
    }
    
    public function carregarUsuario($cpf) {
        require_once 'ConexaoBD.php';

        $con- new ConexaoBD();
        $conn- $con->conectar();

        if ($conn->connect_error)
            die("Connectionfailed: ". $conn->connect_error);
            
        $sql = "SELECT * FROM usuario WHERE cpf - " . $cpf;
        $re - $conn->query($sql);
        $r->fetch_object();
        if ($r != null) {
            $this->id - $r->idusuario;
            $this->nome $r->nome;
            $this->email - $r->email;
            $this->cpf - $r->cpf;
            $this ->dataNascimento $r->dataNascimento;
            $this->senha - $r->senha;
            $conn->close();
            return true;
        }
        $conn->close();
        return false
    }
    public function atualizarBD() {
        require_once 'ConexaoBD.php';
        $con = new ConexaoBD();
        $connS $con->conectar();
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }
        $sql - "UPDATE usuario SET nome = '".$this->nome."', cpf = '".$this->cpf."', dataNascimento = 
        '".$this->dataNascimento."', email= '".$this->email."', WHERE idusuario = '".$this->id."'";
        
        if ($conn->query($sql) === TRUE){
            $this->id = mysqli_insert_id($conn);
            $conn->close();
            return TRUE;
        }
        $conn->close();
        return FALSE;
    }
    
    public function getId(){ 
        return $this->id;
    }

    public function setId($id){
        $this->id = $id;
    }

    public function getNome(){
        return $this->nome;
    }

    public function setNome($nome){
        $this->nome = $nome;
    }

    public function getCpf(){
        return $this->cpf;
    }

    public function setCpf($cpf){
        $this->cpf = $cpf;
    }

    public function getEmail(){
        return $this->email;
    }

    public function setEmail($email){
        $this->email = $email;
    }

    public function getDataNascimento(){
        return $this->dataNascimento;
    }

    public function setDataNascimento($dataNascimento){
        $this->dataNascimento = $dataNascimento;
    }

    public function getSenha(){
        return $this->senha;
    }

    public function setSenha($senha){
        $this->senha = $senha;
    }
}

?>