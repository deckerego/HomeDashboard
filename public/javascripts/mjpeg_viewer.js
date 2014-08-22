function renderCamera(canvasId, sourceUrl) {
    var canvas = document.getElementById(canvasId);
    canvas.innerHTML = "Cannot Set HTML 2D Context";

    try {
        var context = canvas.getContext('2d');

        var image = new Image();
        image.src = sourceUrl;

        function drawFrame() {
            context.drawImage(image, 0, 0, canvas.width, canvas.height);
            window.requestAnimationFrame(drawFrame);
        }

        drawFrame();
    } catch(Throwable) {
        canvas.innerHTML = "Cannot Set HTML 2D Context";
    }
}
