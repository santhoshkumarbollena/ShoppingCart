 var a,b,c,l;
            //firstname validation
            var color;
            function textfn()
            {
                var fn="firstname";
                var label="labelfn";
                var x=document.getElementById(fn).value;
                
               if(!x.match(/^[a-zA-Z]{3,}$/)){
                    procces(x,"invalid firstname","red",label);
                    return false;
                }
               procces(x,"valid firstname","green",label);
               return true;
            }
            //lastname validation
            function textln()
            {
                var ln="lastname";
                var label="labelln";
                var x=document.getElementById(ln).value;
                
               if(!x.match(/^[a-zA-Z]{3,}$/)){
                    procces(x,"invalid lastname","red",label);
                    return false;
                }
               procces(x,"valid lastname","green",label);
               return true;
            }
            
            //validatinng email
            function email12()
            {
                var email="email1";
                var label="labelmail";
                var x=document.getElementById(email).value;
                
               if(!x.match(/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/)){
                    procces(x,"invalid email","red",label);
                    return false;
                }
               procces(x,"valid email","green",label);
               return true;
            }
            //validating password
             function pwd()
            {
                var pwd="password";
                var label="labelpwd";
                var x=document.getElementById(pwd).value;
                
               if(!x.match(/^[a-z0-9A-Z]{6,}$/)){
                    procces("","invalid password ","red",label);
                    return false;
                }
               procces("","valid password","green",label);
               return true;
            }
            //validating re entered password
             function repwd()
            {
                var pwd="password";
                var repwd="repassword";
                var label="labelrepwd";
                var x=document.getElementById(pwd).value;
                var y=document.getElementById(repwd).value;
              if(x!=y){
                   procces("","not matched","red",label);
               return true;
              }
               procces("","matched","green",label);
               return true;
            }
            //validating phone number
             function phno()
            {
                var phno="phonenumber";
                var label="labelphno";
                var x=document.getElementById(phno).value;
                
               if(!x.match(/^[0-9]{10}$/)){
                    procces(x,"invalid phone number","red",label);
                    return false;
                }
               procces(x,"valid phonenumber","green",label);
               return true;
            }
            
            function procces( a,b,c,l)
            {
                document.getElementById(l).innerHTML=a+" is "+b;
                document.getElementById(l).style.color=c;
                color=c;
            }
            function Empty()
            {
            	document.getElementById("labelphno").innerHTML="";
            	document.getElementById("labelrepwd").innerHTML="";
            	document.getElementById("labelpwd").innerHTML="";
            	document.getElementById("labelmail").innerHTML="";
            	document.getElementById("labelln").innerHTML="";
            	document.getElementById("labelfn").innerHTML="";
            }
           