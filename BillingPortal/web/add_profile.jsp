<%-- 
    Document   : add_profile
    Created on : Jun 15, 2021, 10:18:25 PM
    Author     : New
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%@ page contentType="text/css" %>--%>
<html>
    <head>
        <title>Login page</title>
        <style type="text/css"> 
            body {
                text-align: center;
                color: blue;
                margin: 0px;
                padding: 0px;
                height: 100vh;
                font-size: 25px;
                background-image: url('background2.jpg');
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                background-color: black;
                color: white;
            }

            #profileName{
                font-size: 20px;
                background-color: white;
                color: black;
                border: none;
                /* cursor: pointer; */
                width: 300px;
                height: 40px;
                border-radius: 70px;
                /* text-align: center; */
                text-align: center;
                font-family: cursive;
                border: none;

            }
            #renew_date{
                font-size: 20px;
                background-color: white;
                color: black;
                border: none;
                /* cursor: pointer; */
                width: 300px;
                height: 40px;
                border-radius: 70px;
                /* text-align: center; */
                text-align: center;
                font-family: cursive;
                border: none;

            }
            
             #service_name{
                font-size: 20px;
                background-color: white;
                color: black;
                border: none;
                /* cursor: pointer; */
                width: 300px;
                height: 40px;
                border-radius: 70px;
                /* text-align: center; */
                text-align: center;
                font-family: cursive;
                border: none;

            }
            
            #call_on {
                font-size: 20px;
                background-color: white;
                color: black;
                border: none;
                /* cursor: pointer; */
                width: 200px;
                height: 40px;
                border-radius: 70px;
                /* text-align: center; */
                text-align: center;
                font-family: cursive;
                border: none;
            } 
             #call_cross {
                font-size: 20px;
                background-color: white;
                color: black;
                border: none;
                /* cursor: pointer; */
               width: 200px;
                height: 40px;
                border-radius: 70px;
                /* text-align: center; */
                text-align: center;
                font-family: cursive;
                border: none;
            } 

             #sms_on {
                font-size: 20px;
                background-color: white;
                color: black;
                border: none;
                /* cursor: pointer; */
                 width: 200px;
                height: 40px;
                border-radius: 70px;
                /* text-align: center; */
                text-align: center;
                font-family: cursive;
                border: none;
            } 
             #sms_cross {
                font-size: 20px;
                background-color: white;
                color: black;
                border: none;
                /* cursor: pointer; */
                width: 200px;
                height: 40px;
                border-radius: 70px;
                /* text-align: center; */
                text-align: center;
                font-family: cursive;
                border: none;
            }
             #data_unit {
                font-size: 20px;
                background-color: white;
                color: black;
                border: none;
                /* cursor: pointer; */
                width: 200px;
                height: 40px;
                border-radius: 70px;
                /* text-align: center; */
                text-align: center;
                font-family: cursive;
                border: none;
            } 
             #sub {
                font-size: 20px;
                background-color: white;
                color: black;
                border: none;
                /* cursor: pointer; */
                width: 300px;
                height: 40px;
                border-radius: 70px;
                /* text-align: center; */
                text-align: center;
                font-family: cursive;
                border: none;
            } 
        </style>

    </head>

    <body>
        <!-- Profile Area -->
        <div>
            <form>
                <div>
                    <h2 style="color:lightskyblue">Add New Profile</h2>
                </div>
                <div>
                    <span>Profile Name</span>
                    <input id="profileName" type="text" placeholder="Enter Profile Name" required name="profileName"/><br><br>
                </div>
                <div >
                    <span>Renew Date</span>
                    <input  id="renew_date" type="date"   name="Renew Date"/>

                </div> 

            </form>
            <!--/////////////////////////////////////////////////////////////////////////////////////////////-->
            <form>
                <div>
                    <h2 style="color:lightskyblue">Add Service To Profile </h2>
                </div>
                <div >
                    <span>Service Name</span>

                    <input id="service_name" type="text" id="addServicetext"  placeholder="Enter Service Name"/>
                </div>

            </form>
            <!--/////////////////////////////////////////////////////////////////////////////////////////////-->
            <form >
                <div >
                    <h2 style="color:lightskyblue">Add Free Units to Profile</h2>
                </div>
                <div >
                    <span>Call Units On Net</span>
                    <input id="call_on" type="number" required min="0" value="0" name="Call Units On Net"/>
                    <label>Unit</label><br><br>
                </div>
                <div >
                    <span>Call Units Cross Net</span>
                    <input id="call_cross" type="number" required min="0" value="0" name="Call Units Cross Net"/>
                    <label>Unit</label><br><br>
                </div>
                <div >
                    <span> SMS Units On Net</span>
                    <input  id="sms_on" type="number" required min="0" value="0" name="SMS Units On Net"/>
                    <label>Unit</label><br><br>
                </div>
                <div >
                    <span> SMS Units Cross Net</span>
                    <input id="sms_cross" type="number" required min="0" value="0" name="SMS Units Cross Net"/>
                    <label>Unit</label><br><br>
                </div>
                <div >
                    <span>Data Units</span>
                    <input id="data_unit" type="number" required min="0" value="0" name="Data Units"/>
                    <label>Unit</label><br><br>
                </div>
                <div >
                    <input id="sub" class="sub" type="submit" value="Submit">  
                </div>  
            </form>
        </div>
    </body>
</html>


