/**
* Template Name: Presento
* Template URL: https://bootstrapmade.com/presento-bootstrap-corporate-template/
* Updated: Jun 06 2024 with Bootstrap v5.3.3
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
*/

(function() {
  "use strict";

  /**
   * Apply .scrolled class to the body as the page is scrolled down
   */
  function toggleScrolled() {
    const selectBody = document.querySelector('body');
    const selectHeader = document.querySelector('#header');
    if (!selectHeader.classList.contains('scroll-up-sticky') && !selectHeader.classList.contains('sticky-top') && !selectHeader.classList.contains('fixed-top')) return;
    window.scrollY > 100 ? selectBody.classList.add('scrolled') : selectBody.classList.remove('scrolled');
  }

  document.addEventListener('scroll', toggleScrolled);
  window.addEventListener('load', toggleScrolled);

  /**
   * Mobile nav toggle
   */
  const mobileNavToggleBtn = document.querySelector('.mobile-nav-toggle');

  function mobileNavToogle() {
    document.querySelector('body').classList.toggle('mobile-nav-active');
    mobileNavToggleBtn.classList.toggle('bi-list');
    mobileNavToggleBtn.classList.toggle('bi-x');
  }
  mobileNavToggleBtn.addEventListener('click', mobileNavToogle);

  /**
   * Hide mobile nav on same-page/hash links
   */
  document.querySelectorAll('#navmenu a').forEach(navmenu => {
    navmenu.addEventListener('click', () => {
      if (document.querySelector('.mobile-nav-active')) {
        mobileNavToogle();
      }
    });

  });

  /**
   * Toggle mobile nav dropdowns
   */
  document.querySelectorAll('.navmenu .toggle-dropdown').forEach(navmenu => {
    navmenu.addEventListener('click', function(e) {
      if (document.querySelector('.mobile-nav-active')) {
        e.preventDefault();
        this.parentNode.classList.toggle('active');
        this.parentNode.nextElementSibling.classList.toggle('dropdown-active');
        e.stopImmediatePropagation();
      }
    });
  });

  /**
   * Scroll top button
   */
  let scrollTop = document.querySelector('.scroll-top');

  function toggleScrollTop() {
    if (scrollTop) {
      window.scrollY > 100 ? scrollTop.classList.add('active') : scrollTop.classList.remove('active');
    }
  }
  scrollTop.addEventListener('click', (e) => {
    e.preventDefault();
    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
  });

  window.addEventListener('load', toggleScrollTop);
  document.addEventListener('scroll', toggleScrollTop);

  /**
   * Animation on scroll function and init
   */
  function aosInit() {
    AOS.init({
      duration: 600,
      easing: 'ease-in-out',
      once: true,
      mirror: false
    });
  }
  window.addEventListener('load', aosInit);

  /**
   * Initiate glightbox
   */
  const glightbox = GLightbox({
    selector: '.glightbox'
  });

  /**
   * Init swiper sliders
   */
  function initSwiper() {
    document.querySelectorAll('.swiper').forEach(function(swiper) {
      let config = JSON.parse(swiper.querySelector('.swiper-config').innerHTML.trim());
      new Swiper(swiper, config);
    });
  }
  window.addEventListener('load', initSwiper);

  /**
   * Initiate Pure Counter
   */
  new PureCounter();

  /**
   * Init isotope layout and filters
   */
  document.querySelectorAll('.isotope-layout').forEach(function(isotopeItem) {
    let layout = isotopeItem.getAttribute('data-layout') ?? 'masonry';
    let filter = isotopeItem.getAttribute('data-default-filter') ?? '*';
    let sort = isotopeItem.getAttribute('data-sort') ?? 'original-order';

    let initIsotope;
    imagesLoaded(isotopeItem.querySelector('.isotope-container'), function() {
      initIsotope = new Isotope(isotopeItem.querySelector('.isotope-container'), {
        itemSelector: '.isotope-item',
        layoutMode: layout,
        filter: filter,
        sortBy: sort
      });
    });

    isotopeItem.querySelectorAll('.isotope-filters li').forEach(function(filters) {
      filters.addEventListener('click', function() {
        isotopeItem.querySelector('.isotope-filters .filter-active').classList.remove('filter-active');
        this.classList.add('filter-active');
        initIsotope.arrange({
          filter: this.getAttribute('data-filter')
        });
        if (typeof aosInit === 'function') {
          aosInit();
        }
      }, false);
    });

  });

  /**
   * Frequently Asked Questions Toggle
   */
  document.querySelectorAll('.faq-item h3, .faq-item .faq-toggle').forEach((faqItem) => {
    faqItem.addEventListener('click', () => {
      faqItem.parentNode.classList.toggle('faq-active');
    });
  });
  const sliderWrap = document.querySelector(".slider__wrap")
  const sliderImg = sliderWrap.querySelector(".slider__img") //보여지는 영역
  const sliderInner = sliderWrap.querySelector(".slider__inner")  //움직이는 영역
  const slider = sliderWrap.querySelectorAll(".slider")     //개별 영역
  const sliderDot = sliderWrap.querySelector(".slider__dot")
  const sliderBtn = sliderWrap.querySelectorAll(".slider__btn a")

  let currentIndex = 0;   //현재보이는 이미지
  let sliderCount = slider.length;  //이미지 갯수
  let sliderWidth = slider[0].offsetWidth;  //이미지 가로값
  let sliderInterval = 1000; //이미지 변경 시간
  let dotIndex = "";


  function init(){
    //이미지 갯수만큼 닷 메뉴 생성
    slider.forEach(() => dotIndex += "<a href='#' class='dot'>이미지</a>");
    sliderDot.innerHTML = dotIndex;

    //첫번째 닷 메뉴에 활성화 표시
    sliderDot.firstChild.classList.add("active");

  }
  init();


  function gotoSlider(num){
    sliderInner.style.transition = "all 400ms"
    sliderInner.style.transform = "translateX("+ -sliderWidth * num+"px)"
    currentIndex = num;

    let dotActive = document.querySelectorAll(".slider__dot .dot")
    dotActive.forEach((active)=>active.classList.remove("active"));
    dotActive[num].classList.add("active")

    //이미지에 맞는 닷
  }


//버튼을 클릭했을 때
  sliderBtn.forEach((btn, index)=>{
    btn.addEventListener("click",()=>{
      let prevIndex = (currentIndex + sliderCount-1) % sliderCount
      let nextIndex = (currentIndex + 1) % sliderCount

      if(btn.classList.contains("prev")){
        gotoSlider(prevIndex)
      } else {
        gotoSlider(nextIndex)
      }
    })
  })
})();