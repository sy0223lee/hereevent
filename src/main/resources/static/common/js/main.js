document.addEventListener("DOMContentLoaded", function() {
    const sliderInner = document.querySelector("#sliderInner");
    const slides = document.querySelectorAll(".slider");
    const nextButton = document.querySelector(".next");
    const prevButton = document.querySelector(".prev");
    const dots = document.querySelectorAll("#sliderDots .dot");
    const sliderWidth = 800; // 슬라이더의 너비를 설정

    let currentIndex = 0;

    function gotoSlider(num) {
        sliderInner.style.transition = "all 400ms";
        sliderInner.style.transform = "translateX(" + -sliderWidth * num + "px)";
        currentIndex = num;

        dots.forEach((dot, index) => {
            dot.classList.toggle("active", index === num);
        });
    }

    nextButton.addEventListener("click", function() {
        let nextIndex = (currentIndex + 1) % slides.length;
        gotoSlider(nextIndex);
    });

    prevButton.addEventListener("click", function() {
        let prevIndex = (currentIndex - 1 + slides.length) % slides.length;
        gotoSlider(prevIndex);
    });

    dots.forEach((dot, index) => {
        dot.addEventListener("click", function() {
            gotoSlider(index);
        });
    });

    gotoSlider(0); // 초기 슬라이더 설정
});