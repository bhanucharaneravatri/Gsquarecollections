/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


function validate(theForm){
  if(theForm.username.value.length===0){
  alert("UserId can't be blank");
  theForm.user.focus();
   return false;
  }else if(theForm.password.value.length===0){
  alert("Password can't be blank");
  theForm.pass.focus();
  return false;
  }else if(theForm.pass.value.length<6){
  alert("Password length can't be less than 6 char");
  theForm.pass.focus();
  return false;
  }
}
