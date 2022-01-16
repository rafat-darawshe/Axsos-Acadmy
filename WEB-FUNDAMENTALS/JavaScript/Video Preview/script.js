console.log("page loaded...");

function playVideo(pla){
  pla.play();
}
function pauseVideo(pla){
  pla.pause();
  pla.currentTim = 0;
}