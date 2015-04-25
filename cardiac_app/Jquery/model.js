 function loadXMLDoc()
  {
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
      if (xmlhttp.readyState==4 && xmlhttp.status==200)
      {
        document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
      }
    }
    xmlhttp.open("GET","http://localhost:8080/RestfulWebservice/rs/service/getSomething?request=Hello",true);
    xmlhttp.send();
  }

function createRequest(flag_v)
{
  if(flag_v == true)
  {
      var myObj = {};
      myObj["Name"] = document.getElementById("fullname").value;
      myObj["Dob"] = document.getElementById("bday").value;
      myObj["Gender"] = document.getElementById("gender").value;
      myObj["Age"] = document.getElementById("age").value;
      myObj["Email"] = document.getElementById("email").value;
      var request = "request=";
      var json = request.concat(JSON.stringify(myObj));
      $.post("http://localhost:8080/RestfulWebservice/rs/service/postSomething",
            json);
    //alert(json);
  }
  startTimer();
  window.location = "index.html#cardiac_data";
}

function getPatientInformation()
{
  var myObj = {};
  var name = document.getElementById("patient_search").value;
  
  var request = "request=";
  request = request.concat(name);
  $.get(
    "http://localhost:8080/RestfulWebservice/rs/service/getSomething",
    request,
    function(data) {
       alert('page content: ' + data);
    }
  );

  /*var obj = jQuery.parseJSON(response);
  document.getElementById("fullname").innerHTML = obj.Name;
  document.getElementById("bday").innerHTML = obj.Dob;
  document.getElementById("gender").innerHTML = obj.Gender;
  document.getElementById("age").innerHTML = obj.Age;
  document.getElementById("email").innerHTML = obj.Email;*/
  //alert(json);
  
}

function startTimer()
{
  //ca_row
  var elements = document.getElementsByClassName("ca_row");
  var str = nodeToString(elements[0]);
  //$('#mytable').append(str);

  //$('#mytable').append(str);
  var count = 0;
  var min = 0;
  var sec = 0;
  var flag = false;
    var timer = $.timer(
      function() {
        
        count++;
        sec++;
        
        if(count%60 == 0)  //1 min
        {
          min++;
          flag = true;
          sec = 0;
        }
        document.getElementById("cpr").innerHTML = 'CPR:' + min + ":" + count%60;
        document.getElementById("epi").innerHTML = 'EPI:' + min + ":" + count%60;
        document.getElementById("code").innerHTML = 'CODE:' + min + ":" + count%60;
        if(min < 4)
          return;
        if(flag == false)
          return;

        //$('.timer').html('Time Elapsed:' + count);
        
       // var element = document.getElementById("mytable");
        //element.id = "someID";
        //element.append($("#table_body"));
      //$("#table_body").appendTo(element);
      //$("#cardiac_data_row").append(element);
      //var elements = document.getElementsByClassName("ca_row");

      var elements = document.getElementById("ca_row_hidden");
      var time = elements.children[0];
      time.id = 'time' + count;
      var t = min + ":" + sec;
      time.innerHTML = t;
      var str = nodeToString(elements);
      flag = false;
      $('#mytable').append(str);
      //$('#mytable').parentElement.scrollTop(1000);

      //var newrow = ""
      //$("#table_body").append(element);

        //$("#cardiac_data_row").append('<a class="ui-btn ui-btn-b" style="margin:-1px;">Other Procedures</a>');
      },
      1000,
      true
    );  
}

var my_node = 0;
var monitoring_node = 0;
var c_id = 0;
var c = 0;
var n;
function onclick_handler(el)
{
    if(el.id == 'add_new')
    {
      var elements = document.getElementById("ca_row_hidden");
      if(my_node == 0)
      { 
        my_node = elements.children[3];
        //alert(el.parentElement.parentElement.innerHTML);
          //el.parentElement.parentElement.parentElement.innerHTML = el.parentElement.parentElement.parentElement.innerHTML + '<div class="parent_fill"> <div class="child_select block_align"> <select name="Pulse" id="Pulse" > <option selected="selected">Select</option> <option >Pea</option> <option>Asystole</option></select></div> <div class="portrait" id = "add_new" onclick="onclick_handler(this);" <img src="/Users/shashi/Desktop/shashi/course_material/advance_project/Jquery/plus.png"> </div>';
        //str = el.parentElement.parentElement.innerHTML + str;
        //el.parentElement.parentElement.innerHTML = el.parentElement.parentElement.innerHTML + str;//el.parentElement.parentElement.children[0].innerHTML;
        //my_node = nodeToStr(str);
        n = my_node.children[0];

      }
     // el.parentElement.parentElement.append(newstr);
     c++;
    // n.id = c;
     var wrapper= document.createElement('div');
      wrapper.innerHTML= my_node.innerHTML;
      var div= wrapper.children[0];
      div.id = c;
     //my_node.id = c;
     //my_node.children[0].children[0].children[0].children[0].children[1].id=c;
     el.parentElement.parentElement.appendChild(div);

    //el.parentElement.parentElement.appendChild(wrapper.children[0]);
    //el.parentElement.parentElement.innerHTML = el.parentElement.parentElement.innerHTML + my_node.innerHTML;
     // alert(el.parentElement.parentElement.innerHTML);
    }
    else if(el.id == 'delete')
    {
      //el.parentElement.innerHTML = '<div class="portrait" id = "add_new" onclick="onclick_handler(this);"> <img src="/Users/shashi/Desktop/shashi/course_material/advance_project/Jquery/plus.png"> </div>';
      //alert(el.id);
      //el.parentNode.removeChild(el);
      //el.parentElement.parentElement.removeChild(el.parentElement.parentElement.children[1])
      el.parentElement.parentElement.removeChild(el.parentElement);
    }

    else if(el.id == 'add_new_monitoring')
    {
       var elements = document.getElementById("ca_row_hidden");
       if(monitoring_node == 0)
        { 
           monitoring_node = elements.children[4];  //monitoring
        //alert(el.parentElement.parentElement.innerHTML);
          //el.parentElement.parentElement.parentElement.innerHTML = el.parentElement.parentElement.parentElement.innerHTML + '<div class="parent_fill"> <div class="child_select block_align"> <select name="Pulse" id="Pulse" > <option selected="selected">Select</option> <option >Pea</option> <option>Asystole</option></select></div> <div class="portrait" id = "add_new" onclick="onclick_handler(this);" <img src="/Users/shashi/Desktop/shashi/course_material/advance_project/Jquery/plus.png"> </div>';
        //str = el.parentElement.parentElement.innerHTML + str;
        //el.parentElement.parentElement.innerHTML = el.parentElement.parentElement.innerHTML + str;//el.parentElement.parentElement.children[0].innerHTML;
        //my_node = nodeToStr(str);
          var n = monitoring_node.children[0];
        }
        c_id++;
        var wrapper= document.createElement('div');
       wrapper.innerHTML= monitoring_node.innerHTML;
       var div= wrapper.children[0];
       div.id = c_id;
       el.id = "delete";
       el.children[0].src = "/Users/shashi/Desktop/shashi/course_material/advance_project/Jquery/delete.png"
        el.parentElement.parentElement.appendChild(div);
      }
      //el.parentElement.innerHTML = '<div class="portrait" id = "add_new" onclick="onclick_handler(this);"> <img src="/Users/shashi/Desktop/shashi/course_material/advance_project/Jquery/plus.png"> </div>';
      //alert(el.id);
      //el.parentNode.removeChild(el);
      //el.parentElement.parentElement.removeChild(el.parentElement.parentElement.children[1])
      //alert("id");
}

function add_new_control(el)
{
    el.parentElement.innerHTML = el.parentElement.innerHTML + '<div class="portrait" id="delete" onclick="add_new_control(this);"> <input type="text" name="data" id="Pulse_check_data"/> <img src="/Users/shashi/Desktop/shashi/course_material/advance_project/Jquery/delete.png"> </div>';
    //alert("shashi");
}
function handle_select_change(el)
{

  if(el.id == 'Intervention')
  {
     
    if(el.value == 'Defrib')
    {
      el.parentElement.style.width='40%';
       //add text
      el.parentElement.parentElement.parentElement.parentElement.children[1].innerHTML+='<input type="text"  name="monitoring" id="monitoring">';
    }
       
    else if(el.value == 'Airway')
    {
      el.parentElement.style.width='40%';
    }
      //add drop down
    else
    {

      //remove 
     el.parentElement.style.width='0%';
   }

   // alert(el.value);
  }
  else
  //el.children[0].children[0].children[0].innerHTML = el.children[0].children[0].children[1].value;
    el.parentElement.children[0].innerHTML=el.value;
  //  alert('reached');
}


function nodeToStr(node) {
   var tmpNode = document.createElement( "div" );
   tmpNode.appendChild(node.cloneNode(true));
   var node = tmpNode.children[0];
   var str = tmpNode.innerHTML;
   tmpNode = node = null; // prevent memory leaks in IE
   return str;
}

function nodeToString (node) {
   var tmpNode = document.createElement( "div" );
   tmpNode.appendChild(node.cloneNode(true));
   var node = tmpNode.children[0];
   //tmpNode.children[0].children[3].children[0].children[1].children[0].src = '/Users/shashi/Desktop/shashi/course_material/advance_project/Jquery/plus.png';
   
   //tmpNode.children[0].children[3].children[0].children[1].id = 'add_new';
   node.removeAttribute("class");

   node.className = "ca_row";
   //$('hidden').toggleClass('disabled');
   //node.style.visibility='visible';
   var str = tmpNode.innerHTML;
   tmpNode = node = null; // prevent memory leaks in IE
   return str;
}


function toggle_handler(node)
{
    var c = node.className;
    var pos = c.search("active");
    if(pos ==  -1)
    {
      //add active class to node
      node.className += ' active';
      node.style.backgroundColor = "rgb(151, 216, 156)";
    } 
    else
    {
      //remove active class from node
      node.className = 'ui-btn ui-shadow ui-corner-all';
      node.style.backgroundColor = "#f6f6f6";

    }
    /*node.toggleClass('active');*/
}