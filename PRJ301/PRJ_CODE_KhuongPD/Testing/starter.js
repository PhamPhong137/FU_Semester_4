document.addEventListener("DOMContentLoaded", function () {
    let currentSlideIndex = 0;
    const slides = document.querySelectorAll(".slider-item");
    const dots = document.querySelectorAll(".slider-dot-item");
    const slideInterval = 3000; // Thời gian chuyển slide là 3000 ms hay 3 giây
  
    function goToSlide(index) {
      if (index < 0) index = slides.length - 1;
      if (index >= slides.length) index = 0;
      slides[currentSlideIndex].style.display = "none";
      slides[index].style.display = "block";
      dots[currentSlideIndex].classList.remove("active");
      dots[index].classList.add("active");
      currentSlideIndex = index;
    }
  
    document.querySelector(".slider-prev").addEventListener("click", function () {
      goToSlide(currentSlideIndex - 1);
    });
  
    document.querySelector(".slider-next").addEventListener("click", function () {
      goToSlide(currentSlideIndex + 1);
    });
  
    document.querySelectorAll(".slider-dot-item").forEach(function (dot, index) {
      dot.addEventListener("click", function () {
        goToSlide(index);
      });
    });
  
    function initSlider() {
      slides.forEach(function (slide, index) {
        slide.style.display = "none";
      });
      slides[currentSlideIndex].style.display = "block";
      dots[currentSlideIndex].classList.add("active");
    }
  
    initSlider();
  
    // Tự động chuyển slide
    setInterval(function () {
      goToSlide(currentSlideIndex + 1);
    }, slideInterval);
  });
  