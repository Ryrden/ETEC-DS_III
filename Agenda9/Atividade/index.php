<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda9-Atividade</title>
</head>

<body>
    <?php 
		require_once 'paciente.php';

		$p = new Pessoa;
		
		$p->setNome("Ryan Souza");
		$p->setRg("12.345.678-9");
		$p->setCpf("123.456.789-100");
		$p->setEndereco("São Carlos, Brasil");
		$p->setProfissao("Software Engineer");

		echo 'Nome: '.$p->getNome().'<br>';
		echo 'Rg: '.$p->getRg().'<br>';
		echo 'Cpf: '.$p->getCpf().'<br>';
		echo 'Endereco: '.$p->getEndereco().'<br>';
		echo 'Profissão: '.$p->getProfissao().'<br>';
		
    
    ?>
</body>

</html>