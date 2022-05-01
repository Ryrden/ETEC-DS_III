<?php
class formacaoAcad {
    private $id;
    private $idusuario;
    private $inicio;
    private $fim;
    private $descricao;

    public function inserirBD() {
        require_once 'ConexaoBD.php'

        $con = new conexaoBD;
        $conn = $con->conectar();

        if ($conn->connect error)
            die("Connection failed: ". $conn->connect error);
        
        $sql = "INSERT INTO formacaoAcademica (idusuario, inicio, fim, descricao)
        VALUES ('".$this->idusuario."','"$this->inicio"','".$this->fim."','".$this->descricao."')";

        if ($conn->query($sql) === TRUE){
            $this->id = mysqli_insert_id($conn);
            $conn->close();
            return TRUE;
        }
        $conn->close();
        return FALSE;
    }

    public function excluirBD($id) {
        require_once 'ConexaoBD.php'

        $con = new conexaoBD;
        $conn = $con->conectar();

        if ($conn->connect error)
            die("Connection failed: ". $conn->connect error);
        
        $sql = "DELETE FROM formacaoAcademica WHERE idformacaoAcademica =
        '".$id"';";

        if ($conn->query($sql) === TRUE){
            $conn->close();
            return TRUE;
        }
        $conn->close();
        return FALSE;
    }
    
    public function listaFormacoes($idusuario) {
        require_once 'ConexaoBD.php'

        $con = new conexaoBD;
        $conn = $con->conectar();

        if ($conn->connect error)
            die("Connection failed: ". $conn->connect error);
        
        $sql = "SELECT * FROM formacaoAcademica WHERE idusuario = 
        '".$idusuario."'";

        $re = $conn->query($sql);
        $conn->close();
        return $re;
    }

    public function getId(){
		return $this->id;
	}

	public function setId($id){
		$this->id = $id;
	}

	public function getIdusuario(){
		return $this->idusuario;
	}

	public function setIdusuario($idusuario){
		$this->idusuario = $idusuario;
	}

	public function getInicio(){
		return $this->inicio;
	}

	public function setInicio($inicio){
		$this->inicio = $inicio;
	}

	public function getFim(){
		return $this->fim;
	}

	public function setFim($fim){
		$this->fim = $fim;
	}

	public function getDescricao(){
		return $this->descricao;
	}

	public function setDescricao($descricao){
		$this->descricao = $descricao;
	}
}
    
?>