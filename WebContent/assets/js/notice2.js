/**
 * 
 */
$(document).ready(function(){

     const items = document.querySelectorAll('.question-box');

      function openCloseAnswer() {
        const answerId = this.id.replace('que', 'ans');

        if(document.getElementById(answerId).style.display === 'block') {
          document.getElementById(answerId).style.display = 'none';
          document.getElementById(this.id + '-toggle');
        } else {
          document.getElementById(answerId).style.display = 'block';
          document.getElementById(this.id + '-toggle');
        }
      }

      items.forEach(item => item.addEventListener('click', openCloseAnswer));

});