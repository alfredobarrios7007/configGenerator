/*!
 * File: scripts.js
 * Project: TelCel Mexico
 * Description: onload functions Jquery
 * Dependencies: jQuery 1.10.2
 * Author: Santi Risco @ Mx, with love for Xumac
 * Data: June 2014
 */

$(document).ready(function() {


  if (typeof nuevasTablasTelcel != "undefined") {
    nuevasTablasTelcel.inicializar();
  }

  $(document).on('click', '.smartphone-capacity li.option-list', function() {
    $('.smartphone-capacity li.selected').removeClass('selected');
    $(this).addClass('selected');
  });

  $(document).on('click', '.smartphone-colors li.option-list', function() {
    $('.smartphone-colors li.selected').removeClass('selected');
    $(this).addClass('selected');
  });


  $(document).on('click', '.js-avanzar', function() {
    avanzar_paso();
  });

  js_contentenido_a_modal();
  ajustar_menus();

  $('#menu_flotante').show();


  $(document).on('click', '.encontrar-mi-plan', function(e) {
    $(this).closest('.slider-planes').fadeOut(700);
  });

  $(document).on('click touchstart', '.cuerpo-detalle-plan .has-pretty-child a', function(e) {
    $('.cuerpo-detalle-plan .encontrar-mi-plan').removeClass('disabled');
  });

  $(document).on('click', '.cuerpo-detalle-plan .volver-detalle-plan', function(e) {
    e.preventDefault();
    var self = $(this);
    self.closest('.international-plans').fadeOut(700, function() {
      $('.cuerpo-detalle-plan .slider-planes').fadeIn();
    });
  });

  $(document).on('mouseenter', '.chat-flotante', function(e) {

    if ($(this).hasClass('menu-flotante-nuevo-chat')) {
      $(this).animate({
        right: "-40px"
      });
    } else {
      $(this).animate({
        right: "0px"
      });
    }

  });


  $(document).on('mouseleave', '.chat-flotante', function(e) {
    e.preventDefault();
    $(this).animate({
      right: "-185px"
    });
  });


  $(document).on('click', '#menu_flotante .chat-flotante', function(e) {
    e.preventDefault();
    window.open("../html/chat_window.html", "Chat window", "height=250,width=460");
  });



  /* Nueva pleca de chat */
  $(document).on('mouseenter', '.menu-flotante-nuevo-chat', function(e) {

    $(this).animate({
      right: "-40px"
    });

  });

  $(document).on('mouseleave', '.menu-flotante-nuevo-chat', function(e) {
    e.preventDefault();
    $(this).animate({
      right: "-185px"
    });
  });

  $(document).on('click', '.menu-flotante-nuevo-chat', function(e) {
    e.preventDefault();
    window.open("../html/chat_window.html", "Chat window", "height=250,width=460");
  });
  /* Fin de Nueva pleca de chat */






  $('.customSelect').on('chosen:showing_dropdown', function(evt, params) {
    $('.r-tabs-anchor').parent().append("<div class='guard'></div>");
  });

  $('.customSelect').on('chosen:hiding_dropdown', function(evt, params) {
    $('.r-tabs-anchor').parent().find('.guard').remove();
  });



  function fixChoosen() {
    var els = jQuery(".chosen-select");
    els.on("chosen:showing_dropdown", function() {
      $(this).parents("div").css("overflow", "visible");
    });
    els.on("chosen:hiding_dropdown", function() {
      var $parent = $(this).parents("div");

      // See if we need to reset the overflow or not.
      var noOtherExpanded = $('.chosen-with-drop', $parent).length == 0;
      if (noOtherExpanded)
        $parent.css("overflow", "");
    });
  }


  function getInternetExplorerVersion()
  // Returns the version of Internet Explorer or a -1
  // (indicating the use of another browser).
  {
    var rv = -1; // Return value assumes failure.
    if (navigator.appName == 'Microsoft Internet Explorer') {
      var ua = navigator.userAgent;
      var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
      if (re.exec(ua) != null)
        rv = parseFloat(RegExp.$1);
    }
    return rv;
  }


  $('.menu-banner').click(function() {
    $(this).toggleClass("menu-desplegado");
  });



  $(document).on("click", ".js-add-current-url", function() {
    var current_href = $(this).attr("href");
    $(this).attr("href", current_href + window.location.href);
  });


  if ($(".paisSelect").length > 0) {
    $(".paisSelect").chosen().change(function() {
      $(this).closest('.js-trip').find(".b3").show();
    });
  }


  $(".navbar-search button").click(function() {
    var url = $("#searchbox2").data("url");
    window.location.replace(url + "?q=" + $("#searchbox2").val());
  });



  $("#searchbox2").keypress(function(event) {
    if (event.which == 13) {
      event.preventDefault();
      var url = $("#searchbox2").data("url");
      window.location.replace(url + "?q=" + $("#searchbox2").val());
    }
  });


  $("#buscar-modalidad-viaje").click(function(e) {

    e.preventDefault()

    if ($("#plan").val() != "Plan de renta" && $("#marca").val() != "Marca de tu telÃ©fono" && $("#modelo").val() != "Modelo" && $("#medio-1").val() != "Medio de transporte" && $("#destino-pais-1").val() != "Destino") {
      $("#mensaje-error-modalidad-viaje").hide();
      $(this).closest('form').submit();
    } else {
      $("#mensaje-error-modalidad-viaje").show();
    }

  });



  $('body').on('news.carrusel', '.xk-js-news-carrusel', function() {
    $(".xk-js-news-carrusel #carrusel-noticias").owlCarousel({
      navigation: true
    });
  });


  $('body').on('change', '#extra-num', function() {

    $("#formulario-mensajes .help-block").each(function() {
      $(this).addClass("hide");
    });

    $("#formulario-mensajes .has-error").each(function() {
      $(this).removeClass("has-error");
    });

    if ($('#recipient-number').attr('disabled')) {
      $('#recipient-number').removeAttr('disabled');
    } else {
      $('#recipient-number').val('');
      $('#recipient-number').attr('disabled', 'disabled');
    }

  });


  /*
      Validacion formulario enviar SMS
  */
  $('#enviar_mensaje_texto_validacion').click(function(e) {
    e.preventDefault();


    if (!$('#recipient-number').attr('disabled')) {

      if (validar_telefono_sms($('#recipient-number')) && validar_mensaje_sms($('#mensaje_sms'))) {
        $(this).closest('form').submit();
      }

    } else {

      if (validacion_minimo($("#form-extra-num"), 2) && validar_mensaje_sms($('#mensaje_sms'))) {
        $(this).closest('form').submit();
      }


    }


  });



  var validacion_minimo = function(formulario, minimo) {

    var elementos_a_validar = formulario.find('input');
    var count = 0;
    var vacio = 0;
    var exito;

    elementos_a_validar.each(function() {

      if ($(this).val() != "") {


        if (validar_telefono_sms($(this))) {
          count++;
        }

      } else {
        vacio++;
        borrar_mensajes_de_error($(this));
      }

    });



    if (count >= minimo && count + vacio == 8) {
      return 1;
    } else if (count < minimo && count + vacio == 8) {
      validar_telefono_sms($("#recipient_number_1"));
      validar_telefono_sms($("#recipient_number_2"));
    } else {
      borrar_mensajes_de_error($("#recipient_number_1"));
      borrar_mensajes_de_error($("#recipient_number_2"));
    }

  };

  var borrar_mensajes_de_error = function(elemento) {
    $("#formulario-mensajes .has-error").each(function() {
      elemento.closest('.form-group').removeClass("has-error");
      elemento.closest('.form-group').find('.help-block').addClass('hide');
    });
  };




  $('[data-toggle="tooltip"]').tooltip();


  $('.panel-in-grid .js-showPanelInGrid').showPanelInGrid();

  $("#carrusel-noticias").owlCarousel({


    navigation: true, // Show next and prev buttons
    slideSpeed: 300,
    paginationSpeed: 400,
    loop: true,
    center: true,
    HoverPause: true,
    navigation: true,
    singleItem: true,
    navigationText: [
      "<i class='icon-SliderLeft'></i>",
      "<i class='icon-SliderRight'></i>"

    ]


  });




  $('.cortado-a-20').each(function(index, value) {
    $(value).html(truncateString($(this).html(), 20));
  });


  $('.cortado-a-40').each(function(index, value) {
    $(value).html(truncateString($(this).html(), 40));
  });


  $('.cortado-a-48').each(function(index, value) {
    $(value).html(truncateString($(this).html(), 48));
  });

  $('.cortado-a-65').each(function(index, value) {
    $(value).html(truncateString($(this).html(), 65));
  });


  $('.cortado-a-120').each(function(index, value) {
    $(value).html(truncateString($(this).html(), 120));
  });



  var identificador = limpiar_hash();

  if ($(identificador).offset()) {

    if (findBootstrapEnvironment() == 'lg' || findBootstrapEnvironment() == 'md') {
      $('html, body').animate({
        scrollTop: $(identificador).offset().top - 100
      }, 1000);
    } else if (findBootstrapEnvironment() == 'xs') {
      $('html, body').animate({
        scrollTop: $(identificador).offset().top + 300
      }, 1000);
    }
  }

  function truncateString(str, length) {
    return str.length > length ? str.substring(0, length) + '' : str;
  }

  function limpiar_hash() {
    return location.hash.replace(/[`~!@$%^&*()|+\-=?;:'",.<>\{\}\[\]\\\/]/gi, '');
  }





  /*
      Validacion email
  */


  $("#consulta_resultado_imei").click(function(e) {

    e.preventDefault();

    if (validar_celular($("#numeroTelefonoPlaceholder")) && validar_imei($("#imeiPlaceholder"))) {
      //$(this).closest('form').submit();
      visibilidadDiv('resultado-imei');
    }

  });



});



$("#consultar_marca_modelo").click(function(e) {

  e.preventDefault();

  console.log("Respuesta del captcha" + grecaptcha.getResponse());

  if (validar_marca($("#marca")) && validar_modelo($("#modelo")) && validar_captcha()) {

    visibilidadDiv('contentMM');

  }


});


function validar_captcha() {

  if (grecaptcha.getResponse().length == 0) {

    $('.error-captcha').removeClass('hide');
    $('.error-captcha').html('Por favor ingresa el Captcha.');

    return false;

  } else {

    $('.error-captcha').addClass('hide');
    return true;

  }

}



function validar_marca(elemento) {

  if (elemento.val() == "") {

    elemento.closest('.form-group').addClass('has-error');
    elemento.closest('.form-group').find('.help-block').removeClass('hide');
    elemento.closest('.form-group').find('.help-block').html('Es necesario seleccionar la marca de tu equipo.');

    return false;

  } else {
    elemento.closest('.form-group').removeClass('has-error');
    elemento.closest('.form-group').find('.help-block').addClass('hide');
    return true;
  }

}



function validar_modelo(elemento) {

  if (elemento.val() == "") {

    elemento.closest('.form-group').addClass('has-error');
    elemento.closest('.form-group').find('.help-block').removeClass('hide');
    elemento.closest('.form-group').find('.help-block').html('Es necesario seleccionar el modelo de tu equipo.');

    return false;

  } else {
    elemento.closest('.form-group').removeClass('has-error');
    elemento.closest('.form-group').find('.help-block').addClass('hide');
    return true;
  }

}


function validar_telefono_sms(elemento) {

  if (elemento.val() == "") {
    elemento.closest('.form-group').addClass('has-error');
    elemento.closest('.form-group').find('.help-block').removeClass('hide');
    elemento.closest('.form-group').find('.help-block').html('Es necesario ingresar el nÃºmero Telcel al que se enviarÃ¡ el mensaje.');
  } else if (elemento.val() != "") {


    if (elemento.val().length != 10) {
      elemento.closest('.form-group').addClass('has-error');
      elemento.closest('.form-group').find('.help-block').removeClass('hide');
      elemento.closest('.form-group').find('.help-block').html('El numero de telÃ©fono no es correcto.');
      return false;
    } else {
      elemento.closest('.form-group').removeClass('has-error');
      elemento.closest('.form-group').find('.help-block').addClass('hide');
      return true;
    }

  }
}

function validar_mensaje_sms(elemento) {
  if (elemento.val() == "") {
    elemento.closest('.form-group').addClass('has-error');
    elemento.closest('.form-group').find('.help-block').removeClass('hide');
    elemento.closest('.form-group').find('.help-block').html('Es necesario ingresar el texto del mensaje.');
    return false;
  } else {
    elemento.closest('.form-group').removeClass('has-error');
    elemento.closest('.form-group').find('.help-block').addClass('hide');
    return true;
  }
}


function validar_imei(elemento) {


  if (elemento.val() == "") {
    elemento.closest('.form-group').addClass('has-error');
    elemento.closest('.form-group').find('.help-block').removeClass('hide');
    elemento.closest('.form-group').find('.help-block').html('Es necesario ingresar el IMEI al que se enviarÃ¡ el mensaje.');
  } else if (elemento.val() != "") {


    if (elemento.val().length != 15) {
      elemento.closest('.form-group').addClass('has-error');
      elemento.closest('.form-group').find('.help-block').removeClass('hide');
      elemento.closest('.form-group').find('.help-block').html('El formato del IMEI no es correcto.');
      return false;
    } else if (!$.isNumeric(elemento.val())) {
      elemento.closest('.form-group').addClass('has-error');
      elemento.closest('.form-group').find('.help-block').removeClass('hide');
      elemento.closest('.form-group').find('.help-block').html('El formato del IMEI no es correcto, debe contenener solo nÃºmeros.');
      return false;
    } else {
      elemento.closest('.form-group').removeClass('has-error');
      elemento.closest('.form-group').find('.help-block').addClass('hide');
      return true;
    }

  }
}


function validar_celular(elemento) {


  if (elemento.val() == "") {
    elemento.closest('.form-group').addClass('has-error');
    elemento.closest('.form-group').find('.help-block').removeClass('hide');
    elemento.closest('.form-group').find('.help-block').html('Es necesario ingresar el nÃºmero de telÃ©fono.');
  } else if (elemento.val() != "") {


    if (elemento.val().length != 10) {
      elemento.closest('.form-group').addClass('has-error');
      elemento.closest('.form-group').find('.help-block').removeClass('hide');
      elemento.closest('.form-group').find('.help-block').html('El formato del telÃ©fono no es correcto.');
      return false;
    } else if (!$.isNumeric(elemento.val())) {
      elemento.closest('.form-group').addClass('has-error');
      elemento.closest('.form-group').find('.help-block').removeClass('hide');
      elemento.closest('.form-group').find('.help-block').html('El formato del telÃ©fono no es correcto, debe contenener solo nÃºmeros.');
      return false;
    } else {
      elemento.closest('.form-group').removeClass('has-error');
      elemento.closest('.form-group').find('.help-block').addClass('hide');
      return true;
    }

  }
}


/*
    fin de validacion SMS
*/



$(function() {


  function desabilitar_recipient_number() {
    $("#recipient-number").attr("disabled", "true");
  }


  /*Common JQuery Selectors, declared here to avoid repetitions*/
  var $slider_planes = $('.js-slider-planes'),
    $range = $("#range"),
    $range_min = $("#range-min"),
    $range_max = $("#range-max"),
    $breadcrumb = $('.breadcrumb'),
    $list_comparador = $('.list-comparador'),
    $bar_comparador = $('.bar-comparador'),
    $formFiltros = $('#form-filtros'),
    $chat = $('#chat');
  /*EOF Common JQuery Selectors*/
  /*Lets clone some elements before they get transformed by plugins*/

  if ($('.js-clone-item ').length) {
    $('.js-clone-item').each(function() {
      $itemToClone = $($(this).data('clone') + ':first').clone();
      $(this).data('cloned', $itemToClone)
    });
  }
  /*Launch of users modal on home*/
  if ($('.home').length) {
    $('#modalSegmentacion').modal({
      remote: '../ajax/segmentacion-usuarios.html',
      backdrop: true
    }).on('loaded.bs.modal', function(e) {
      if ($('.desktop').length) {
        $('.customSelect').chosen({
          width: "100%"
        });
      }
    });
  }


  /* Small widgets */
  /*BS-Tooltips*/
  $('.js-tooltip').tooltip();



  /*Tabs in user dropdowns*/
  $('.login-title a').click(function(e) {
    e.preventDefault();
    $(this).tab('show').parent().addClass('active').siblings().removeClass('active');
  });
  /*Avoid form submission on each button inside the form*/
  $('button.js-unsubmit').click(function(e) {
    e.preventDefault();
  });
  /*LazyLoad images outside Carousels*/
  $("img.lazyLoad").show().lazyload({
    threshold: 300,
    skip_invisible: false
  });
  /*Up button*/
  $('.up_button').click(function() {
    $("html, body").animate({
      scrollTop: 0
    }, 600);
    return false;
  });
  /*Zone Change*/
  $('.js-select-location').on('click', 'a', function() {
    $(this).closest('ul').prev().find('span').text($(this).text());
    if ($(this).closest('ul').prev().find('span').text() === " United States") {
      window.open("http://www.tracfone.com/");
      $(this).closest('ul').prev().find('span').text(" MÃ©xico");
    } else {

    }
  }).css({
    'max-height': $(window).height() - 60,
    'overflow': 'scroll'
  });

  $('.js-select-location').on('mouseover', 'a', function() {
    if (!$(this).hasClass("por-defecto")) $(this).closest('ul').find('.por-defecto').removeClass('por-defecto');
  });

  /*BS Panels*/
  $('body').on('show.bs.collapse', '.panel-collapse', function() {
    $(this).prev('.panel-heading').addClass("active");
  }).on('hide.bs.collapse', '.panel-collapse', function() {
    $(this).prev('.panel-heading').removeClass("active");
  });
  /******************************************
  * We need an absolute height for the div holding
  * the front and side images of the phone in order
  * to draw pseudo elements with the measures
   *****************************************
   $('.js-measures').each(function(){
       $(this).css({
           height:$(this).innerHeight()
       })
   });*/

  /* EOF Small widgets */

  /*Forms customization*/
  $('.customCheck, .customRadio').each(function() {
    $(this).prettyCheckable();
  });





  $('.customSelect').each(function() {


    var search = $(this).data('search');
    var ancho = $(this).data('width') + '%';
    var inherit = $(this).data('inherit');
    $(this).chosen({
      disable_search_threshold: search,
      width: '100%',
      inherit_select_classes: inherit
    })
  });
  $('body').on('change', '.js-select-card', function() {
    var idcard = $(this).val(),
      jsondata = $(this).data('load'),
      $data_holder = $('.js-credit-card-data');
    $data_holder.removeClass('preloaded');
    if ($data_holder.not(':visible')) {
      $data_holder.collapse('show');
    }
    //Auto fill credit card form with data
    function drawCreditCardData(data) {
      datacards = data;
      $.each(data.cards, function(key, val) {
        if (data.cards[key].id == idcard) {
          $.each(data.cards[key].data, function(key, val) {
            $data_holder.find('input[name="' + key + '"]').val(val);
            $data_holder.find('select[name="' + key + '"]').val(val).trigger("chosen:updated");
          });
          $('#type_card_icon').removeClass();
          $('#type_card_icon').addClass('card').addClass('card-' + data.cards[key].data['type_card']);
        }
      });
    }
    //Get JSON data if first resquest, else get only data.
    // IMPORTANT
    // Â¡Â¡Â¡JSON CARD DATA Should be deleted on new login and unlogin!!!!
    if (typeof datacards === 'undefined') {
      $.getJSON(jsondata, drawCreditCardData);
    } else {
      drawCreditCardData(datacards);
    }
  }).on('change', '.js-fileinput', function() {
    var input = $(this),
      numFiles = input.get(0).files ? input.get(0).files.length : 1,
      label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.trigger('fileselect', [numFiles, label]);
  });
  $('.js-fileinput').on('fileselect', function(event, numFiles, label) {
    alert('naranjas')
    var input = $(this).closest('.input-group').find('.js-fileInputtext'),
      log = numFiles > 1 ? numFiles + ' files selected' : label;
    if (input.length) {
      input.val(log);
    } else {
      if (log) alert(log);
    }
    console.log(log)
  });
  //If is new car, remove data
  $('body').on('click', '.js-new-card', function(e) {
    e.preventDefault();
    $data_holder = $('.js-credit-card-data');
    $data_holder.addClass('preloaded');
    $data_holder.find('input').val('');
    $data_holder.find('select').val('').trigger("chosen:updated");
    if ($data_holder.not(':visible')) {
      $data_holder.collapse('show');
    }
  });
  /*EOF Forms customization*/

  $('body').on('change', '.js-onchange-show', function() {
    var id = $(this).val();
    $(this).find('option').each(function() {
      $($(this).val()).hide();
    });
    $(id).fadeIn();
  });

  $('body').on('click', '.js-onclick-show .btn', function() {
    var id_show = $(this).data('show');
    $(this).closest('.js-onclick-show').hide();
    $(id_show).removeClass('hidden');
  });




  /*Custom plugins*/
  /*Simple AJAX form submission*/
  $(document).on("submit", ".js-ajax-form", function(event) {

    event.preventDefault();

    $(this).simpleAjaxForm({
      callback: function(obj, target) {

        //Load recharge subform
        if ($(target).hasClass('js-reload-form')) {
          var target = $('.js-form-recarga');
          var url = target.data('alt-url');
          $.ajax({
              url: url,
              dataType: 'HTML'
            }).done(function(result) {

              $(target).html(result).css({
                  'opacity': '1',
                  'height': 'auto'
                })
                .find('.customSelect').each(function() {
                  var search = $(this).data('search');
                  var ancho = $(this).data('width') + '%';
                  $(this).chosen({
                    disable_search_threshold: search,
                    width: '100%'
                  });
                });
              $(target).find('[data-trigger-events]').each(function() {
                $(this).dataTriggerEvent();
              });
            })
            .fail(function() {
              // alert(target)
              $(target).prepend('<div class="container-fluid "><div class="alert alert-warning fade in">' + settings.mensajeError + '</div></div>').css({
                'opacity': '1'
              });
              $(target).find('.alert').delay('800').slideUp('slow');
            });
        }
        if (obj.hasClass('js-recharge-steps')) {
          $('.js-steps').find('.active').removeClass('active').next().addClass('active');
        }
      }
    });

  });






  $('.js-simpleAjaxTabs').simpleAjaxTabs({
    spin: 'xlargeSpin',
    callback: function(obj, target) {


      $(target).find('.js-showPanelInGrid').showPanelInGrid();
      //}
      //if (target == "#plan-ideal") {

      $(target).find(".js-slider-planes").each(function() {
        renderSliderPlanes($(this));
      });

      /*Ajax Form Submission*/
      $(target).find('.js-form-slider-planes').on("submit", function(event) {
        event.preventDefault();
        var target = $(this).data('ajax-target');
        var form = $(this);
        if ($(target).is(':empty')) {
          form.simpleAjaxForm();
          $(target).animate({
            'height': '150'
          }, function() {

          });
        }
      });

      /*Automatic reload of results layer on form input or slider change*/
      $('#sliderTarget,#order-resultados').on('change', 'select, input', function() {
        $(this).closest('form').simpleAjaxForm({
          spin: 'largeSpin'
        });
      });
      //}
    }
  });
  /*EOF Custom plugins*/

  /*Events attached to body*/
  $('body')
    .on('click', 'button.js-tooltip', function(e) {
      e.preventDefault();
    })
    /*Generic close buttons*/
    .on('click', '.js-close', function() {
      var detach = ($(this).hasClass('js-detach')) ? true : false;
      $(this).closest('.js-close-target').animate({
        'height': 0,
        'padding': 0
      }, function() {
        if (detach) {
          $(this).detach();
        } else {
          $(this).hide();
        }
      });
    })
    /*Avoid close of login box on self tabs click*/
    .on('click', '.login-box', function(e) {
      e.stopPropagation()
    })
    //Display hidden texts
    .on('click', '.js-display-text', function(e) {
      var button = $(this),
        target = button.prev(),
        curHeight = 70,
        autoHeight = target.css('height', 'auto').height(),
        newHeight = (button.hasClass('opened')) ? curHeight : autoHeight,
        oldHeight = (button.hasClass('opened')) ? autoHeight : curHeight;
      target.height(oldHeight).animate({
        height: newHeight
      }, 1000, function() {
        button.toggleClass('opened');
        target.toggleClass('visible');
      });
      e.stopPropagation();
    })
    .on('click', '.js-open-chat', function(e) {
      $chat.find('header').trigger('click');
    });
  //Remove selected filers and reload form

  /*EOF Events attached to body*/



  /*SIMPLE Carousels
   * The options "items" and "slideBy" are received from data-attr
   * */
  var simpleCarousel = function($carousel) {
    $carousel.owlCarousel({
      itemsDesktop: [979, $carousel.data('items')],
      margin: 10,
      loop: true,
      center: true,
      HoverPause: true,
      navigation: true,
      singleItem: $carousel.data('single-item'),
      slideBy: $carousel.data('slideby'),
      lazyLoad: true,
      navigationText: ['<i class="icon-SliderLeft"></i>', '<i class="icon-SliderRight"></i>'],
      beforeMove: function(elem) {
        if (elem.parent('.carousel-noticias').length) {
          elem.find('.owl-wrapper').height(elem.find('.owl-wrapper').height())
        }
      }
    });
  };

  var ancho_inicial = 0;
  var simpleCarouselNoResponsive = function($carousel) {
    $carousel.owlCarousel({
      itemsDesktop: [979, 1],
      itemsTablet: [768, 1],
      itemsMobile: [479, 1],
      margin: 10,
      loop: true,
      center: true,
      HoverPause: true,
      navigation: true,
      singleItem: true,
      slideBy: $carousel.data('slideby'),
      lazyLoad: true,
      navigationText: ['<i class="icon-SliderLeft"></i>', '<i class="icon-SliderRight"></i>'],
      beforeMove: function(elem) {
        if (elem.parent('.carousel-noticias').length) {
          elem.find('.owl-wrapper').height(elem.find('.owl-wrapper').height())
        }
      }
    });

  };





  /*

      Scroll automatico de 12 en 12

  */

  var lista_completa_faqs = $('#preguntas-frecuentes-slider li');
  var contador = 0;
  var ul = $("<ul class='row bordered-grid-primary define-faq'></ul>");



  var inicializar_carrusel = function() {

    $('#preguntas-frecuentes-slider-div').empty();
    lista_completa_faqs.each(function(key, val) {


      if (contador == 0) {
        ul = $("<ul class='row bordered-grid-primary define-faq'></ul>");
        agregar_lista($('#preguntas-frecuentes-slider-div'), ul, val);
        contador++;
      } else if (contador < 12) {
        agregar_lista($('#preguntas-frecuentes-slider-div'), ul, val);
        contador++;
      } else if (contador == 12) {
        ul = $("<ul class='row bordered-grid-primary define-faq'></ul>");
        agregar_lista($('#preguntas-frecuentes-slider-div'), ul, val);
        contador = 1;
      }



    });

    simpleCarouselNoResponsive($('#preguntas-frecuentes-slider-div'));

  }

  function agregar_lista(contenedor, lista, elemento) {
    contenedor.append(lista.append(elemento));
  }



  inicializar_carrusel();





  $('.js-simple-carousel').each(function() {
    simpleCarousel($(this));
  });

  $('.js-simple-carousel-ajax').each(function() {
    var target = $(this),
      url = $(this).data('url');

    $.get(url).done(function(html) {
      $(target).html(html);

      $(target).find('.js-simple-carousel').each(function() {
        simpleCarousel($(this));
      }).find('.customCheck').each(function() {
        $(this).prettyCheckable();
      })
    });
  });


  $('.opciones-si-amigo').click(function() {
    $('#tabs-siplan button').toggleClass('active');
    $('#tabs-siplan ul').toggleClass('open');
    $('#tabs-siplan i').toggleClass('icon-AccordionUp');

  });

  /****** EOF SLIDERS ******/

  var getTabActivate = function(responsiveTab) {
    var active = responsiveTab.find('.active').index();
    return active ? active : 0;
  };

  /*BOF Responsive Tabs*/
  /*Option 1, displayed as Accordions*/
  $('.js-responsiveTabs').each(function() {

    var responsiveTab = $(this);
    $(this).responsiveTabs({
      active: getTabActivate(responsiveTab),
      rotate: false,
      startCollapsed: false,
      collapsible: 'accordion',
      setHash: true,
      animation: 'slide',
      activate: function(e, tab) {
        if ($(tab.accordionAnchor[0]).data('target') == "#ayuda") {
          $('.js-showPanelInGrid').showPanelInGrid();
        }

        if (typeof nuevasTablasTelcel != "undefined") {
          nuevasTablasTelcel.inicializar();
        }

        e.preventDefault();
      }
    }); //.responsiveTabs('activate', getTabActivate(responsiveTab));
  });



  $(document).on('click', '.js-carousel-menu', function(e) {

    e.preventDefault();


    $('html, body').animate({
      scrollTop: 0
    }, 1000);


    $.each($('.r-tabs-panel'), function(index, value) {
      $(this).hide();
    });

    $.each($('.js-carousel-menu'), function(index, value) {
      $(this).removeClass('active');
    });

    $(this).addClass('active');
    $($(this).attr('href')).toggle();

    var flecha_izquierda = $('.arrow-container-left');
    var flecha_derecha = $('.arrow-container-right');

    if ($(this).offset().left < 0) {
      $('.carousel-menu-responsive').animate({
        scrollLeft: '-=' - 130
      }, "fast");
    } else if ($(this).offset().left > ($(window).width() - 40 - 130)) {
      $('.carousel-menu-responsive').animate({
        scrollLeft: '+=' + 130
      }, "fast");
    }

  });


  $(document).on('click', '.arrow-container-left a', function(e) {
    e.preventDefault();

    var delta = $('.js-carousel-menu').first().css('width');
    $('.carousel-menu-responsive').animate({
      scrollLeft: '-=' + delta
    }, "fast");

  });


  $(document).on('click', '.arrow-container-right a', function(e) {
    e.preventDefault();

    var delta = $('.js-carousel-menu').first().css('width');
    $('.carousel-menu-responsive').animate({
      scrollLeft: '+=' + delta
    }, "fast");
  });



  function carousel_menu_responsive_width() {
    $('.carousel-container').width(window.innerWidth);
    $('.carousel-menu-responsive').width(window.innerWidth - 40);
    $('.inner-carousel').width(($('.js-carousel-menu').length * 130));
  }





  /*Option 2, displayed as Selector*/
  $(document).on('click', '.js-nav-pills-open', function() {
    console.log('click');
    $(this).toggleClass('active').next().toggleClass('open');
  }).next('ul').on('click', 'li > a', function() {
    $(this).closest('ul').removeClass('open').prev().removeClass('active').find('span').text($(this).text());
  });
  /*EOF Responsive Tabs*/

  /*-------------------
   * "Planes" Range Slider
   * and
   * results layer reload
   * ------------------- */

  /*var renderSliderPlanes = function($slider) {
      var min = $slider.data('min'),
          max = $slider.data('max'),
          step = $slider.data('step'),
          value_min = $slider.data('value-min'),
          value_max = $slider.data('value-max'),
          options = $slider.data('options').split(', ');

      $slider.slider({
          range: true,
          min: min,
          max: max,
          step: step,
          stop: function (event, ui) {
              var ajaxRequest = $slider.data('ajax');
              if (ajaxRequest) {
                  $slider.simpleAjaxForm({spin: 'largeSpin'});
              }
          },
          values: [ value_min, value_max ],
          slide: function (event, ui) {
              $slider.parent().find('.input-rango').val(options[ ui.values[ 0 ] ] + " - " + options[ ui.values[ 1 ] ]);
              $slider.parent().find('.range-min').val(ui.values[0]);
              $slider.parent().find('.range-max').val(ui.values[1]);
          }
      });

      Predefined values of slider onLoad
      $slider.parent().find('.input-rango').val(options[ $slider.slider("values", 0) ] + " - " + options[ $slider.slider("values", 1) ]);
      $slider.parent().find('.range-min').val($slider.slider("values", 0));
      $slider.parent().find('.range-max').val($slider.slider("values", 1));
  };

  $(".js-slider-planes").each(function() {
      renderSliderPlanes($(this));
  });
  */
  /*Ajax Form Submission*/
  $('.js-form-slider-planes, .js-form-internet').on("submit", function(event) {
    event.preventDefault();
    var target = $(this).data('ajax-target');
    var form = $(this);

    //if ($.trim($(target).html())=='') {
    $(target).animate({
      'height': '150'
    }, function() {
      form.simpleAjaxForm({
        callback: function(ob, target) {
          var topPos = $(target).offset().top - $('.navbar-static-top.afixed').height() - 15;
          $('html, body').animate({
            scrollTop: topPos
          }, 500);
          if ($(target).find('.mini-slider').length) {
            $('.mini-slider').each(function() {
              var steps = $(this).data('steps').split(',');
              $(this).slider({
                create: function(event, ui) {
                  var units = $(this).data('units');
                  var stepWidth = 100 / (steps.length - 1);
                  var $scale = $(this).next().next('.scale');
                  if ($scale.is(':empty')) {
                    for (i = 0; i < steps.length; i++) {
                      pos = i * stepWidth;
                      $('<div/>', {
                        'class': 'step'
                      }).css({
                        'left': pos + '%'
                      }).text(steps[i] + units).appendTo($scale);
                    }
                  }
                },
                range: "min",
                value: 0,
                min: 0,
                max: steps.length - 1,
                step: 1,
                slide: function(event, ui) {
                  $(this).next().val(steps[ui.value]);
                }
              })
            });
          }
        }
      });
    })
    //}
  });
  $('.js-range-radio').on('change', '.js-range-position', function() {
    $(this).closest('.has-pretty-child').siblings().find('label').css('opacity', '.5');
    $(this).closest('.has-pretty-child').find('label').css('opacity', '1');
    if ($($(this).closest('.js-range-radio').data('ajax-target')).length) {
      var ajaxRequest = $(this).closest('.js-range-radio').data('ajax');
      if (ajaxRequest) {
        $(this).closest('.js-range-radio').simpleAjaxForm({
          spin: 'largeSpin'
        });
      }
    }
  });
  /*Automatic reload of results layer on form input or slider change*/
  $('#sliderTarget,#order-resultados').on('change', 'select, input', function() {
    $(this).closest('form').simpleAjaxForm({
      spin: 'largeSpin'
    });
  });

  /*-------------------
   *EOF Range Slider "Planes"
   -------------------*/

  /*--------------
   * Scroll Events
   ---------------*/
  $(window).scroll(function() {

    if (($(document).scrollTop() > window.innerHeight)) {
      $('.up_button').addClass('visible');
    } else {
      $('.up_button').removeClass('visible');
    }

    show_carousel();
    ajustar_menus();


  });

  if ($('.cloudzoom').length) {
    CloudZoom.quickStart();
  }

  /*TO-DO Create a custom plugin to perform ajax links*/
  $('body').on('click', '.js-ajax-link', function(e) {
    var $link = $(this),
      URL = $link.attr('href'),
      target = $($link.data('target'));
    $(target).animate({
      'opacity': '.5'
    }, function() {
      loader = $('<div/>', {
        'class': 'spinner-holder clear'
      }).css({
        'position': 'absolute',
        'bottom': '50%',
        'right': '50%'
      }).appendTo(target).spin('defaultSpin');
      $.ajax({
        url: URL,
        success: function(data, textStatus, jqXHR) {
          $(target).find('.spinner-holder').spin(false);
          $(target).html(data).css({
            'opacity': '1',
            'height': 'auto'
          }).find('.customCheck').each(function() {
            $(this).prettyCheckable();
          });

          var accentMap = {
            "Ã¡": "a",
            "Ã©": "e",
            "Ã­": "i",
            "Ã³": "o",
            "Ãº": "u"
          };
          var normalize = function(term) {
            var ret = "";
            for (var i = 0; i < term.length; i++) {
              ret += accentMap[term.charAt(i)] || term.charAt(i);
            }
            return ret;
          };

          $(target).find('.customSelect,.customRadio').each(function() {
            var search = $(this).data('search');
            var ancho = $(this).data('width') + '%';
            if ($('.desktop').length) {
              $(this).chosen({
                disable_search_threshold: search,
                width: '100%'
              });
            }
          });
          onAjaxSuccess(target);
          $(target).find('[data-trigger-events]').each(function() {
            $(this).dataTriggerEvent();
          });
        },
        error: function(jqXHR, textStatus, errorThrown) {
          $('<div/>', {
            'class': 'ajax-error text-center',
            'text': 'Error'
          }).appendTo(target);
          target.find('.spinner-holder').spin(false);
        }
      });
    });
    e.preventDefault();
  });

  /* Modal ajax */
  $(document).on('click', '.js-modal-ajax', function(e) {
    var url = $(this).data('url');

    $('#modalAjax').modal({
      remote: url,
      backdrop: true
    });
    e.preventDefault();
  });
  $('body').on('click', '.js-Ajax-Custom-Modal', function(e) {
    var $el = $(this);
    url = $el.attr('href'),
      target = $el.data('target');
    $(target).find('.modal-content').empty().load(url, function() {
      $(target).modal();
    });
    e.preventDefault();
  });
  $(document).on('show.bs.modal', '.modal', function() {
    var zIndex = 1040 + (10 * $('.modal:visible').length);
    $(this).css('z-index', zIndex);
    setTimeout(function() {
      $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
    }, 0);
  });

  function clearFullItem() {
    $(this).replaceWith('<li class="empty">&nbsp;</li>');
    counter = $list_comparador.find('li.full').length;
    $bar_comparador.find('.counter').text(counter);
  }
  /*Funciones para el comparador de terminales*/
  $list_comparador.on('click', '.js-delete-comparador', function(e) {
    e.preventDefault();
    var element = $(this).next().val();
    clearFullItem.call($(this).closest('li'));
    $('.item-terminal').each(function() {
      var val = $(this).find('input').val();
      if (val == element) {
        $(this).find('input:checked').prettyCheckable('uncheck');
      }
    });
  });
  $(document).on('change', '.js-checkboxComparar', function(e) {

    //ajustar_comparador();

    var URL = url_comparador,
      padre = ($(this).closest('.item-terminal')) ? $(this).closest('.item-terminal') : $(this).closest('.item-accesorios'),
      img = $(this).data('terminal-image'),
      equipo = $(this).val(),
      action = ($(this).is(':checked')) ? 1 : 0;
    padre.find('.small-tooltip').detach();

    if (action == 1) {
      // Add only if less than 3
      if ($list_comparador.find('li.full').length < 3) {
        var tooltip = $('<div/>', {
          'class': 'small-tooltip clearfix',
          'html': '<div class="pull-left"><img src="' + img + '"/></div><p>Has aÃ±adido el ' + equipo + ' al comparador <span>AÃ±ade otro equipos para empezar a comparar</span></p>'
        }).css({
          'position': 'absolute',
          'top': '50%',
          'left': '50%'
        }).appendTo(padre).delay('2000').fadeOut('slow');

        var counter = $list_comparador.find('li.full').length;
        $bar_comparador.fadeIn();
        var new_item = '<li class="full"><img src="' + img + '" alt="' + equipo + '"/><a href="#" rel="nofollow" data-item="' + equipo + '" class="js-delete-comparador"><i class="fa fa-times-circle"></i></a><input type="hidden" name="terminal-comparar[]" value="' + equipo + '"/></li>';

        $list_comparador.find('li.empty').eq(0).replaceWith(new_item);
        counter += 1;
        $bar_comparador.find('.counter').text(counter);

      } else {
        var tooltip = $('<div/>', {
          'class': 'small-tooltip clearfix',
          'html': '<p>Tan sÃ³lo puedes comparar 3 equipos simultaneamente<br><br><br></p>'
        }).css({
          'position': 'absolute',
          'top': '50%',
          'left': '50%'
        }).appendTo(padre).delay('2000').fadeOut('slow');
        var target = e.target;
        setTimeout(function() {
          $(target).prettyCheckable('uncheck');
          console.log('eso');
        }, 1);

      }
    } else {
      var tooltip = $('<div/>', {
        'class': 'small-tooltip clearfix',
        'html': '<div class="pull-left"><img src="' + img + '"/></div><p>Has eliminado el ' + equipo + ' del comparador <br><br><br></p>'
      }).css({
        'position': 'absolute',
        'top': '50%',
        'left': '50%'
      }).appendTo(padre).delay('2000').fadeOut('slow');


      var element = equipo;
      $('.list-comparador > li').each(function() {
        var val = $(this).find('input').val();
        if (val == element) {
          clearFullItem.call(this);
        }
      });
    }

  });


  /*Drop items form shoppin bag*/
  if ($('.item-carrito').length) {
    $('.js-cesta-vacia').hide();
  }
  $('.js-carrito').on('click', '.js-delete-lista', function() {
    var equipo = $(this).data('item');
    var $padre = $(this).closest('.js-carrito');
    var URL = $padre.data('url-process');
    var total_cesta = Number($padre.find('.js-total-cesta').text().replace(/[^0-9\.]+/g, ""));
    var item_price = Number($(this).closest('.js-close-target').find('.js-price').text().replace(/[^0-9\.]+/g, ""));
    $.ajax({
      url: URL,
      data: {
        terminal: equipo
      },
      success: function(data, textStatus, jqXHR) {
        //Recalcular el total de la cesta
        var total = '$' + parseFloat((total_cesta - item_price), 10).toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
        $('.js-total-cesta').text(total)
        if ((total_cesta - item_price) == 0) {
          $('.js-totales').slideUp().next('.js-cesta-vacia').fadeIn();
        }
      },
      error: function(jqXHR, textStatus, errorThrown) {
        var tooltip = $('<div/>', {
          'class': 'small-tooltip clearfix error',
          'html': '<p>Se ha producido un error</p>'
        }).css({
          'position': 'absolute',
          'top': '50%',
          'left': '50%'
        }).appendTo($padre).delay('2000').fadeOut('slow');
      }
    });
  })

  /*--------------
   * BOF Filters action in products search list
   ---------------*/

  $formFiltros.on('change', '.searchbox-filter', function() {
    $('.js-filtersbar').fadeOut(function() {
      $(this).remove();
    });

    $formFiltros.find('.js-checkboxFilters').each(function() {
      if (this.checked) {
        $(this).prettyCheckable('uncheck');
      }
    });
    $formFiltros.find('select').each(function() {
      $(this).val('').trigger("chosen:updated");
    });

    $formFiltros.simpleAjaxForm({
      spin: 'largeSpin'
    });
  });

  $formFiltros.on('change', 'select', function() {
    var next = $(this).data('next');

    $(this).closest('form').simpleAjaxForm({
      spin: 'largeSpin'
    });
    $(next).fadeIn();
  });

  $('body').on('click', '.resultados-update-ajax', function(e) {
    e.preventDefault();
    $(this).closest('form').simpleAjaxForm({
      spin: 'largeSpin'
    });
  });

  $('#load-items a, .js-open-pills').click(function() {
    $('#filtros').collapse({
      toggle: false
    }).collapse('hide');
    $('*[data-target="#filtros"]').addClass('collapsed');
    $(this).parent().addClass('active').siblings().removeClass('active');

  });
  $('*[data-target="#filtros"]').click(function() {
    $('#load-items').collapse({
      toggle: false
    }).collapse('hide');
    $('.js-open-pills').addClass('collapsed');
  });

  $('body').on('change', '.js-checkboxFilters', function() {
    var $form = $(this).closest('form'),
      label = $(this).data('label'),
      value = $(this).val(),
      action = ($(this).is(':checked')) ? 1 : 0,
      $filtersbar = (!$('.js-filtersbar').length) ? $('<ul/>', {
        'class': 'list-filters list-unstyled container-fluid js-filtersbar'
      }) : $('.js-filtersbar'),
      $item = (action == 1) ? $('<li/>', {
        'html': '<i class="icon-Close"></i>' + label + '',
        'class': 'js-delete-filter item',
        'data-value': value
      }) : $('li[data-value="' + value + '"]');
    $form.simpleAjaxForm({
      spin: 'largeSpin',
      callback: function() {
        if ((action == 1)) {
          $item.appendTo($filtersbar);
          if (!$('.js-filtersbar').length)
            $filtersbar.appendTo('.js-selected-filtres');
        } else {
          $item.animate({
            width: 0
          }, function() {
            $(this).detach();
            if (!$('.js-filtersbar').find('li').length) {
              $filtersbar.animate({
                height: 0
              }, function() {
                $(this).detach();
              });
            }
          });
        }
      }
    });
    $($(this).data('next')).fadeIn();
  }).on('click', '.js-delete-filter', function() {
    var checkbox = $formFiltros.find('input[value="' + $(this).data('value') + '"]');
    checkbox.prettyCheckable('uncheck');
    $(this).animate({
      width: 0
    }, function() {
      $(this).detach();
      if (!$('.js-filtersbar').find('li').length) {
        $('.js-filtersbar').animate({
          height: 0
        }, function() {
          $(this).detach();
        });
      }
    });
    $formFiltros.simpleAjaxForm({
      spin: 'largeSpin'
    });
  });
  /*--------------
   * EOF Filters action in products search list
   ---------------*/

  /*--------------
   * BOF Rich headers in admin pages
   ---------------*/
  var $richHeader = $('.js-rich-header');
  $richHeader.each(function() {
    var bgPosition = $(this).data('bgposition'),
      bgRepeat = $(this).data('bgrepeat'),
      bgImage = $(this).data('bg-image')
    //alert(bgImageSizeRd)
    $(this).css({
      'background-repeat': bgRepeat,
      'background-image': 'url(' + bgImage + ')',
      'background-position': bgPosition
    });
  });
  /*--------------
   * EOF Rich headers in admin pages
   ---------------*/


  $('body').on('click', '.js-clone-item', function(e) {

    //console.log($($(this).data('clone')).parent());

    var $itemCloned = $(this).data('cloned').clone(true),
      $holder = $($(this).data('clone')).parent();
    ordinal = $($(this).data('clone')).length + 1;
    classParent = $itemCloned.attr('class').split('-')[0];


    $itemCloned.removeClass("zindex-1");
    $itemCloned.addClass(classParent + '-' + ordinal);
    $holder.append($itemCloned);
    $itemCloned.find('.chosen-container').detach();
    $itemCloned.find('.customSelect').each(function() {
      idExtract = $(this).attr('id').split('-')[0];
      $(this).attr('id', idExtract + '-' + ordinal);
      var search = $(this).data('search');
      var ancho = $(this).data('width') + '%';
      var inherit = $(this).data('inherit');
      $(this).chosen({
        disable_search_threshold: search,
        width: '100%',
        inherit_select_classes: inherit
      })
    });
    //$(this).data('cloned','');

    $(".paisSelect").chosen().change(function() {
      $(this).closest('.js-trip').find(".b3").show();
    });

    e.preventDefault()
  });

  $('body').on('change', '.js-checkboxSelectPlan', function() {
    var value = $(this).val(),
      price = parseFloat($(this).data('price')),
      itemCategory = parseFloat($(this).data('category')),
      itemSubcategoryPrice = $(".subTotal" + itemCategory),
      itemSubcategoryoldTotal = parseFloat(itemSubcategoryPrice.text()),
      action = ($(this).is(':checked')) ? 1 : 0,
      $item = $(this).closest('.item'),
      oldTotal = parseFloat($('.js-total').find('.js-ammount').text()),
      prevAmount = 0;
    if (action == 1) {
      $item.addClass('selected');
      $item.siblings('.item').each(function() {
        var $checkbox = $(this).find('.js-checkboxSelectPlan');
        if ($(this).find('.js-checkboxSelectPlan').is(':checked')) {
          $checkbox.prettyCheckable('uncheck');
          prevAmount = parseFloat($checkbox.data('price'));
        }
      }).removeClass('selected');
      $(".subTotal" + itemCategory).text(price);
      $(".subTotalContainer" + itemCategory).show();
      newTotal = oldTotal + price - prevAmount;
    } else {
      $(this).closest('.item').removeClass('selected');
      $(".subTotalContainer" + itemCategory).hide();
      $(".subTotal" + itemCategory).text("0.00");
      newTotal = oldTotal - price;
    }
    $('.js-total').find('.js-ammount').text(newTotal);
  }).on('click', '.js-delete-subtotal', function(e) {
    var itemCategory = parseFloat($(this).data('category'));
    /*price  = parseFloat($(".subTotal" + itemCategory).text()),
    oldTotal = parseFloat($('.js-total').find('.js-ammount').text())
    newTotal=oldTotal-price;*/
    $('.js-checkboxSelectPlan').each(function() {
      if ($(this).data('category') == itemCategory && $(this).is(':checked')) {
        //alert($(this).attr('id'))
        $(this).prettyCheckable('uncheck');
        $(this).trigger('change');
      }
    });
    $(".subTotalContainer" + itemCategory).hide();
    e.preventDefault();
  });




  $('.js-radio-tab').on('change', function() {
    $(this).tab('show');
  });

  $('.js-planes-extranjero .primeraFila').on('click', 'select, input, div', function() {
    $(this).find('.chosen-container').css('z-index', 2000);
  });


  function ResizeIframeFromParent(id) {
    if (jQuery('#' + id).length > 0) {
      var window = document.getElementById(id).contentWindow;
      var prevheight = jQuery('#' + id).attr('height');
      var newheight = Math.max(window.document.body.scrollHeight, window.document.body.offsetHeight, window.document.documentElement.clientHeight, window.document.documentElement.scrollHeight, window.document.documentElement.offsetHeight);
      if (newheight != prevheight && newheight > 0) {
        jQuery('#' + id).attr('height', newheight);
      }
    }
  }

  function initialize() {
    var mapOptions = {
      center: new google.maps.LatLng(19.4270499, -99.1275711),
      zoom: 16,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map_canvas"),
      mapOptions);
  }
  $('body').on('change', '.js-mark-row', function() {
    $(this).closest('tr').toggleClass('mark');
  }).on('click', '.js-mark-all-rows', function() {
    var $target = $($(this).data('target')),
      action = $(this).data('action');
    $(this).parent().addClass('active').siblings().removeClass('active');
    if (action == 1) {
      $target.find('.js-mark-row').prettyCheckable('check');
      $target.find('tbody tr').addClass('mark');
    } else {
      $target.find('.js-mark-row').prettyCheckable('uncheck');
      $target.find('tbody tr').removeClass('mark');
    }
  });
  $('.js-external-accordion').on('show.bs.collapse', function() {
    setTimeout(function() {
      $('iframe.js-autosize').each(function() {
        ResizeIframeFromParent($(this).attr('id'));
      });
    }, 300);
  });
  if ($('.resize-iframe').length) {
    var iframeWin = window.parent.document.getElementById("iframe-10");
    iframeWin.height = document.body.scrollHeight + 40;
  }
  $('.js-accordion-panels').on('shown.bs.collapse', function() {
    $(this).find('.collapse.in').find('.js-showPanelInGrid').showPanelInGrid();
  });
  //AcordeÃ³n generado por CQ5
  $('.js-cq-accordion').on('show.bs.collapse', function() {
    $(this).find('.collapse.in').collapse('hide')
  }).on('shown.bs.collapse', function() {
    var idOpened = $(this).find('.collapse.in').attr('id');
    $('html, body').animate({
      scrollTop: $('#' + idOpened).offset().top - 250
    }, 500);
  });
  if ($('#map_canvas').length) {
    initialize();
  }

  $('.js-checkbox-collapse').on('change', function() {
    action = ($(this).is(':checked')) ? 1 : 0;
    if (action == 1) {
      $($(this).data('target')).collapse('show')
    } else {
      $($(this).data('target')).collapse('hide')
    };
  });
  $('.mini-slider').each(function() {
    var steps = $(this).data('steps').split(',');
    $(this).slider({
      create: function(event, ui) {
        var units = $(this).data('units');
        var stepWidth = 100 / (steps.length - 1);
        var $scale = $(this).next().next('.scale');
        if ($scale.is(':empty')) {
          for (i = 0; i < steps.length; i++) {
            pos = i * stepWidth;
            $('<div/>', {
              'class': 'step'
            }).css({
              'left': pos + '%'
            }).text(steps[i] + units).appendTo($scale);
          }
        }
      },
      range: "min",
      value: 0,
      min: 0,
      max: steps.length - 1,
      step: 1,
      slide: function(event, ui) {
        $(this).next().val(steps[ui.value]);
      }
    })
  });







  /*
      Galerias de ganadores dinamicas
  */

  var sync1 = $(".js-gallery-images");
  var sync2 = $(".js-gallery-thumbs");


  sync2.each(function(index, value) {

    $(this).owlCarousel({
      items: 6,
      itemsDesktop: [1199, 6],
      itemsDesktopSmall: [979, 5],
      itemsTablet: [768, 6],
      itemsTablet: [650, 5],
      itemsMobile: [479, 2],
      pagination: false,
      responsiveRefreshRate: 100,
      afterInit: function(el) {
        el.find(".owl-item").eq(0).addClass("synced");
      }
    });

  });



  sync1.each(function(index, value) {

    $(this).owlCarousel({
      singleItem: true,
      slideSpeed: 1000,
      navigation: true,
      pagination: false,
      afterAction: syncPosition,
      responsiveRefreshRate: 200,
      lazyLoad: true,
      navigationText: ['<i class="icon-SliderLeft"></i>', '<i class="icon-SliderRight"></i>']
    });

  });


  sync2.each(function() {

    $(this).on("click", ".owl-item", function(e) {
      e.preventDefault();
      var number = $(this).data("owlItem");
      sync1.each(function() {
        $(this).trigger("owl.goTo", number);
      });
    });

  });


  function syncPosition(el) {

    var s2 = el.closest('.owl-carousel').next('.js-gallery-thumbs');

    var current = this.currentItem;
    s2
      .find(".owl-item")
      .removeClass("synced")
      .eq(current)
      .addClass("synced")
    if (s2.data("owlCarousel") !== undefined) {
      center(current, s2)
    }
  }


  function center(number, s2) {
    var sync2visible = s2.data("owlCarousel").owl.visibleItems;
    var num = number;
    var found = false;
    for (var i in sync2visible) {
      if (num === sync2visible[i]) {
        var found = true;
      }
    }

    if (found === false) {
      if (num > sync2visible[sync2visible.length - 1]) {
        s2.trigger("owl.goTo", num - sync2visible.length + 2)
      } else {
        if (num - 1 === -1) {
          num = 0;
        }
        s2.trigger("owl.goTo", num);
      }
    } else if (num === sync2visible[sync2visible.length - 1]) {
      s2.trigger("owl.goTo", sync2visible[1])
    } else if (num === sync2visible[0]) {
      s2.trigger("owl.goTo", num - 1)
    }
  }

  /*
     Fin de Galerias de ganadores dinamicas
  */




  /*
      Chat
  */
  $chat.on('click', 'header', function() {
    if ($chat.hasClass('open')) {
      $chat.removeClass('open');
    } else {
      $chat.addClass('open');
    }
  });

  /*
      Carousel Ofertas
   */
  $(document).on('click', '.js-close-carousel-ofertas', function(e) {
    e.preventDefault();
    $(this).closest('.carousel-ofertas').fadeOut(function() {
      $(this).remove();
    });
  });

  /*
      Remove on click
   */
  $('.js-remove-onclick').on('click', function() {
    $(this).remove();
  });

  /*
      Input only numbers
   */
  $(document).on('keypress', '.js-only-numbers', function(e) {
    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
      return false;
    }
  });

  $('body').on('keypress', '.js-only-alpha-numeric', function(e) {

    var charCode = (e.which) ? e.which : e.keyCode;
    if (charCode == 8) return true;

    var keynum;
    var keychar;
    var charcheck = /[a-zA-Z0-9]/;
    if (window.event) // IE
    {
      keynum = e.keyCode;
    } else {
      if (e.which) // Netscape/Firefox/Opera
      {
        keynum = e.which;
      } else return true;
    }

    keychar = String.fromCharCode(keynum);
    return charcheck.test(keychar);


  });




  // REMOVE
  //
  $('body').on('test-1', '.resultados.inner', function(e, arg1, arg2) {
    console.log('From test 1');
    console.log(arg1);
    console.log(arg2);
  });

  // REMOVE
  //
  $('body').on('test-2', '.resultados.inner', function() {
    console.log('From test 2');
  });
  // Fix triangle boxes in IE
  $('.svg-angle-box').each(function() {
    var width = $(this).width();
    $(this).css('height', Math.round(width * 0.041));
  });
  $('modal').on('click, touchstart', '.chosen-container', function(e) {
    e.stopPropagation();
  })

}); //ready

//
//  History
//------------------------------------------------

$(function() {
  /*
  if (history && typeof(history.pushState)=='function') {
      window.addEventListener('load', function () {
          setTimeout(function () {
              window.addEventListener('popstate', function () {
                  window.location.replace(document.location);
              });
          }, 0);
      });
  }
  */
});

//
//  Separate 200Mb to <span class="number">200</span><span class="text">Mb</span>
//  ----------------------------------------------

$(function() {
  $('.intstring').separateIntString();
});

//
// Hashtag tabs
// -----------------------------------------------

$(function() {
  var targetArray = window.location.toString().split('#!');



  if (targetArray.length == 2) {
    $('.tabsToselect-xs [data-target="#' + targetArray[1] + '"]').trigger('click');
  } else {
    $('.tabsToselect-xs .js-simpleAjaxTabs > li.active > a').trigger('trigger-click');
  }

  $(document).on('click', '.js-simpleAjaxTabs > li > a', function(e) {
    $(this).closest('.open').removeClass('open');

    if (typeof nuevasTablasTelcel != "undefined") {
      nuevasTablasTelcel.inicializar();
    }
  });


  $('.soporte-tabs').on('click', '> li > a', function(e) {
    var scrollTop = $(window).scrollTop(),
      elementOffset = $(this).offset().top,
      distance = (elementOffset - scrollTop);
    window.scrollTo(0, elementOffset - 130);
  });


});

function posicionar_tooltips(elemento) {
  elemento.parent().css('position', 'relative');
  elemento.tooltip('toggle');
}


//
// Modal
// ------------------------------------------------

$(function() {

  var ancho_pantalla = $(window).width();

  var centerModal = function($modal) {
    var modalHeight = $('.modal-content', $modal).outerHeight(),
      windowHeight = $(window).height();

    if (windowHeight > modalHeight) {
      var margin = ((windowHeight - modalHeight) / 2);
      $('.modal-dialog', $modal).animate({
        'margin': margin + 'px auto'
      }, 100);
    }
  };

  $('.modal').on('shown.bs.modal', function() {
    centerModal(this);
  });

  $(window).resize(function() {

    var ancho_actual = $(window).width();
    var diferencia_en_pixeles = ancho_pantalla - ancho_actual;

    ancho_pantalla = ancho_actual;
    var modals = $('.modal-centered');

    $.each(modals, function() {
      centerModal(this);
    });

    carousel_menu_responsive_width();
    show_carousel();
    js_contentenido_a_modal();

  });


  generate_responsive_carousel();
  carousel_menu_responsive_width();
  show_carousel();


  /*
    Deben cargar despues de que se adapten los carruseles y menus dinamicos
  */
  js_contentenido_a_modal();

  ajustar_menus();
  //ajustar_comparador();

});



function js_contentenido_a_modal() {

  if (findBootstrapEnvironment() === 'xs' || findBootstrapEnvironment() === 'sm') {
    $.each($('.js-contenido-copia'), function() {
      $('.js-contenido-modal').html($(this).html());
      $('.js-contenido-modal').height($(window).height() - 160);
    });
  }
}



function show_carousel() {

  var pantalla = findBootstrapEnvironment();
  var contenedor = $('.carousel-container');
  var contenedor2 = $('.carousel-menu-responsive');
  var special_tabs = $('.r-tabs-accordion-title');




  if ($('.carousel-container').length === 0 && pantalla === "xs" || pantalla === "sm") {
    $('.r-tabs-accordion-title').show();
  }

  if ($('.carousel-container').length > 0) {

    if (pantalla === "xs" || pantalla === "sm") {
      contenedor.show();
      contenedor2.show();
      special_tabs.hide();
    } else {
      contenedor.hide();
      contenedor2.hide();
    }
  }



}




function generate_responsive_carousel() {

  var contenedor_principal = $("<div class='carousel-container' style='display: none;'></div>");
  var contenedor_flecha_izquierda = $("<div class='arrow-container-left'><a href='#'><i class='icon-SliderLeft' aria-hidden='true'></i></a></div>");
  var dummy_container = $("<div class='carousel-menu-responsive'></div>");
  var inner_carousel = $("<div class='inner-carousel'></div>");
  var contenedor_flecha_derecha = $("<div class='arrow-container-right'><a href='#'><i class='icon-SliderRight' aria-hidden='true'></i></a></div>");

  $.each($('.r-tabs-tab a'), function(index, value) {

    if ($(this).closest('li').hasClass('active')) {
      var a = "<a href='" + $(this).attr('href') + "' class='js-carousel-menu active'><i class='" + $(this).find('i').attr('class') + "'></i><h2>" + $(this).find('h2').html() + "</h2></a>";
    } else {
      var a = "<a href='" + $(this).attr('href') + "' class='js-carousel-menu'><i class='" + $(this).find('i').attr('class') + "'></i><h2>" + $(this).find('h2').html() + "</h2></a>";
    }
    inner_carousel.append(a);
  });

  contenedor_principal.append(contenedor_flecha_izquierda);
  dummy_container.append(inner_carousel);
  contenedor_principal.append(dummy_container);
  contenedor_principal.append(contenedor_flecha_derecha);
  $('.special-tabs').before(contenedor_principal);
  carousel_menu_responsive_width();

}



function carousel_menu_responsive_width() {

  $('.carousel-container').width(window.innerWidth);
  $('.carousel-menu-responsive').width(window.innerWidth - 90);
  $('.inner-carousel').width(($('.js-carousel-menu').length * 130));

}



window.mobileAndTabletcheck = function() {
  var check = false;
  (function(a) {
    if (/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows ce|xda|xiino|android|ipad|playbook|silk/i.test(a) || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(a.substr(0, 4))) check = true
  })(navigator.userAgent || navigator.vendor || window.opera);
  return check;
}

String.prototype.isEmail = function() {
  var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(this);
}



function findBootstrapEnvironment() {
  var envs = ['xs', 'sm', 'md', 'lg'];

  $el = $('<div>');
  $el.appendTo($('body'));

  for (var i = envs.length - 1; i >= 0; i--) {
    var env = envs[i];

    $el.addClass('hidden-' + env);
    if ($el.is(':hidden')) {
      $el.remove();
      return env
    }
  };
}




function misma_altura() {


  var max_height;

  if ($('.js-same-height').length > 0) {

    $.each($('.js-same-height'), function() {

      //Current height
      var ch = $(this).height();
      if (!max_height) max_height = ch;
      else if (ch > max_height) max_height = ch;
    });

    $.each($('.js-same-height'), function() {
      $(this).height(max_height);
    });

  }

}



function ajustar_comparador() {
  var res = findBootstrapEnvironment();
  if (res === 'sm' || res === 'xs') {
    console.log(res);
    $('.carousel-container').hide();
    $('body').css('margin-top', '190px');
  }
}



function ajustar_menus() {

  var resolucion = findBootstrapEnvironment();

  if (resolucion === "sm") {

    if ($('.header-main').length > 0) {

      if ($('.breadcrumb-holder').length > 0) {
        $('.breadcrumb-holder').show();
        $('.breadcrumb-holder').addClass('breadcrumb-movil');
        $('body').css('margin-top', '100px');
      } else {
        $('body').css('margin-top', '50px');
      }

      if ($('.carousel-container').length > 0) {
        $('body').css('margin-top', '190px');
        $('.carousel-container').css('top', '100px');
      }

    }

  } else if (resolucion === "xs") {


    if ($('.header-main').length > 0) {

      if ($('.breadcrumb-holder').length > 0) {
        $('.breadcrumb-holder').show();
        $('.breadcrumb-holder').addClass('breadcrumb-movil');
        $('body').css('margin-top', '100px');
      } else {
        $('body').css('margin-top', '60px');
      }

      if ($('.carousel-container').length > 0) {
        $('body').css('margin-top', '135px');
        $('.caroursel-container').css('top', '45px');
      }


    }


  } else {
    if ($('.header-main').length > 0) {

      $('body').css('margin-top', '0px');

      if ($('.breadcrumb-holder').length > 0) {
        $('.breadcrumb-holder').removeClass('breadcrumb-movil');
      }

    }
  }

}



var responsive_tables = function() {

  var resolution = findBootstrapEnvironment();

  if ($('.js-tc').length > 0 && resolution === "xs") {

    $('.tc-div').remove();

    $.each($('.js-tc'), function() {

      var self = $(this);


      var t_head = function() {
        var th = [];
        $.each(self.find('thead tr th'), function() {
          th.push($(this).html());
        });
        return th;
      }();


      var t_rows = function() {

        var tr = [];
        var container_tables = document.createElement('div');

        $.each(self.find('tbody tr'), function() {

          var new_table = document.createElement("table");
          new_table.className += " table-card";

          $.each($(this).find('td'), function(i, v) {

            if (t_head[i] === "Mapa") $(new_table).append('<tr><td class="n-p" colspan="2">' + $(this).html() + '</td></tr>');
            else $(new_table).append('<tr><td style="text-align:left !important;">' + t_head[i] + '</td><td>' + $(this).html() + '</td></tr>');
          });

          container_tables.className = 'owl-carousel';
          container_tables.className = ' tc-div';
          container_tables.appendChild(new_table);

        });

        $(container_tables).owlCarousel({
          stagePadding: 100,
          loop: true,
          center: true,
          HoverPause: true,
          navigation: false,
          singleItem: true,
          lazyLoad: true
        });

        self.closest('.tc-container').append(container_tables);

      }();

      self.hide();

    });



  } else {
    $('.js-tc').show();
    $('.table-card').hide();
    $('.tc-container .owl-pagination').hide();
  }


};

function avanzar_paso() {
  $('.js-steps').find('.active').removeClass('active').next().addClass('active');
}
