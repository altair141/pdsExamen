<?php

class PacienteForm extends CFormModel{
	public $id;
	public $nombre;
	public $apellido;
	public $fechaNacimiento;
	public $uuid;
	public $direccion;
	public $estado;


public function rules(){
	return array(
 		array('id','integer'),
 		array('fechaNacimiento','date'),
		);
}

public function attributeLabels(){
	return array(
		'nombre'=>'Nombre del paciente:',
		'apellido'=>'Apellido del paciente:',
		'fechaNacimiento'=>'Fecha de nacimiento del paciente',
		'direccion'=>'Dirección del paciente',
		
		);
}

}

?>