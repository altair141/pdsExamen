<?php
/* @var $this SiteController */
/* @var $model ContactForm */
/* @var $form CActiveForm */

$this->pageTitle=Yii::app()->name . ' - Contact Us';
$this->breadcrumbs=array(
	'Contact',
);
?>

<h1>Contact Us</h1>

<?php if(Yii::app()->user->hasFlash('contact')): ?>

<div class="flash-success">
	<?php echo Yii::app()->user->getFlash('contact'); ?>
</div>

<?php else: ?>

<p>
If you have business inquiries or other questions, please fill out the following form to contact us. Thank you.
</p>

<div class="form">

<?php /** @var BootActiveForm $form */
$form = $this->beginWidget('bootstrap.widgets.TbActiveForm', array(
    'id'=>'inlineForm',
    'type'=>'inline',
    'htmlOptions'=>array('class'=>'well well-small'),
)); ?>

	<p class="note">Fields with <span class="required">*</span> are required.</p>

	<?php echo $form->errorSummary($model); ?>

	<div class="control-group" >

  <div class="controls" >
     
     <div class="input-prepend" >
		<?php echo $form->labelEx($model,'name'); ?>
		<?php echo $form->textField($model,'name',array('class'=>'input-small')); ?>
		<?php echo $form->error($model,'name'); ?>
	
	</div>
	</div>
<div class="controls" >
    <div class="input-prepend" >
      <span class="add-on"><i class="icon-envelope"></i></span>
  
		<?php echo $form->textField($model,'email',array('class'=>'span-5','placeholder'=>'@email')); ?>
		<?php echo $form->error($model,'email'); ?>
    </div>
    <div class="input-prepend" >
    <?php echo $form->labelEx($model,'subject'); ?>
		<?php echo $form->textField($model,'subject',array('size'=>60,'maxlength'=>128,'class'=>'form-control')); ?>
		<?php echo $form->error($model,'subject'); ?>
		</div>
  </div>

		
 
	
		<?php echo $form->textArea($model,'body', array('class'=>'span6', 'rows'=>4,'placeholder'=>'ANAMNESIS')); ?>
		<?php echo $form->error($model,'body'); ?>

</div>
	<?php if(CCaptcha::checkRequirements()): ?>
	<div class="row">
		<?php echo $form->labelEx($model,'verifyCode'); ?>
		<div>
		<?php $this->widget('CCaptcha'); ?>
		<?php echo $form->textField($model,'verifyCode'); ?>
		</div>
		<div class="hint">Please enter the letters as they are shown in the image above.
		<br/>Letters are not case-sensitive.</div>
		<?php echo $form->error($model,'verifyCode'); ?>
	</div>
	<?php endif; ?>

	<div class="row buttons">
		<?php echo CHtml::submitButton('Submit',array('class'=>'btn btn-primary')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- form -->

<?php endif; ?>