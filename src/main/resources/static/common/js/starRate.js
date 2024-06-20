$(document).ready(function() {
    const rateWrap = document.querySelectorAll('.rating');
    const label = document.querySelectorAll('.rating .rating-label');
    const input = document.querySelectorAll('.rating .rating-input');
    const labelLength = label.length;
    let stars = document.querySelectorAll('.rating .star-icon');

    checkedRate();

    rateWrap.forEach(wrap => {
        wrap.addEventListener('mouseover', () => {
            stars = wrap.querySelectorAll('.star-icon');

            stars.forEach((starIcon, idx) => {
                starIcon.addEventListener('mouseenter', () => {
                    if (wrap.classList.contains('readonly') === false) {
                        initStars(); // 별점 초기화
                        filledRate(idx, labelLength); // 마우스 호버된 만큼 별점 채우기
                    }
                });

                starIcon.addEventListener('mouseleave', () => {
                    checkedRate(); // 체크된 라디오 버튼만큼 별점 active
                });
            });
        });
    });

    // 가리키고 있는 별점보다 낮은 별들은 채워주기
    function filledRate(index, length) {
        if (index <= length) {
            for (let i = 0; i <= index; i++) {
                stars[i].classList.add('filled');
            }
        }
    }

    // 선택된 별점보다 낮은 별들은 채워주기
    function checkedRate() {
        let checkedRadio = document.querySelectorAll('.rating input[type="radio"]:checked');

        initStars();
        checkedRadio.forEach(radio => {
            let previousSiblings = prevAll(radio);

            for (let i = 0; i < previousSiblings.length; i++) {
                previousSiblings[i].querySelector('.star-icon').classList.add('filled');
            }

            radio.nextElementSibling.classList.add('filled');

            function prevAll() {
                let radioSiblings = [];
                let prevSibling = radio.parentElement.previousElementSibling;

                while (prevSibling) {
                    radioSiblings.push(prevSibling);
                    prevSibling = prevSibling.previousElementSibling;
                }
                return radioSiblings;
            }
        });
    }

    function initStars() {
        for (let i = 0; i < stars.length; i++) {
            stars[i].classList.remove('filled');
        }
    }
});