<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<style type="text/css">

    /* @group Blink */
    .blink {
        -webkit-animation: blink .75s linear infinite;
        -moz-animation: blink .75s linear infinite;
        -ms-animation: blink .75s linear infinite;
        -o-animation: blink .75s linear infinite;
        animation: blink .75s linear infinite;
    }
    @-webkit-keyframes blink {
        0% { opacity: 1; }
        50% { opacity: 1; }
        50.01% { opacity: 0; }
        100% { opacity: 0; }
    }
    @-moz-keyframes blink {
        0% { opacity: 1; }
        50% { opacity: 1; }
        50.01% { opacity: 0; }
        100% { opacity: 0; }
    }
    @-ms-keyframes blink {
        0% { opacity: 1; }
        50% { opacity: 1; }
        50.01% { opacity: 0; }
        100% { opacity: 0; }
    }
    @-o-keyframes blink {
        0% { opacity: 1; }
        50% { opacity: 1; }
        50.01% { opacity: 0; }
        100% { opacity: 0; }
    }
    @keyframes blink {
        0% { opacity: 1; }
        50% { opacity: 1; }
        50.01% { opacity: 0; }
        100% { opacity: 0; }
    }
    /* @end */

</style>


<section id="main-content">
    <section class="wrapper site-min-height">
        <h3><i class="fa fa-angle-right"></i> Dashboard</h3>
        <div class="row mt">
            <div class="col-lg-12">

                <!--          		<p>Place your content here.</p>-->

                <!--                                <div class="table-responsive" id="top" style="height:380px; width:1000px; margin:0 auto;" >
                                                    <div id="ResultArea" style="width:900px; margin:0 auto;">
                                                    </div>  
                                                </div>-->


                <div class="row mt">
                    <div class="col-lg-12">


                        <div class="content-panel">

                            <h4><i class="fa fa-angle-right"></i>Quartz Scheduler</h4>
                            <section id="unseen">
                                <div  class="table-responsive">
                                    <div   id="ResultArea" ></div>
                                </div>
                            </section>
                        </div><!-- /content-panel -->
                    </div><!-- /col-lg-4 -->			
                </div><!-- /row -->


                <div class="row mt">
                    <div class="col-lg-12">


                        <div class="content-panel">

                            <h4><i class="fa fa-angle-right fa-clock-o"></i> <i class="fa  fa-clock-o fa-2x fa-spin text-primary"></i>Cron Expression Builder <i class="fa  fa-clock-o fa-spin fa-2x text-primary"></i></h4>
                            <section id="unseen">

                                <form class="form-horizontal">
                                    <div class="form-group">

                                        <label class=" col-sm-2 control-label" for = "Select" ><b>Select: </b></label>
                                        <div class="col-sm-3">
                                            <span class="form-control" id='cronExpressionDiv'/>
                                        </div>
                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label"for = "cronExpression" ><b>Corn Expression : </b></label>
                                        <div class="col-sm-3">
                                            <span class="form-control"   id='cronExpressionGenerator' />
                                        </div>
                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label"for = "cronExpression" ><b>Generated cron : </b></label>
                                        <div class="col-sm-3">
                                            <span class='form-control text-danger' id='genratedCronExpression'>  </span>
                                        </div>
                                    </div>

                                </form>
                            </section>
                        </div><!-- /content-panel -->
                    </div><!-- /col-lg-4 -->			
                </div><!-- /row -->





                <div class="row mt">
                    <div class="col-lg-12">


                        <div class="content-panel">

                            <h4><i class="fa fa-angle-right"></i>Job Scheduler</h4>
                            <section id="unseen">

                                <div  class="table-responsive">
                                    <div  id="JobSchedularResultArea" ></div>
                                </div>


                                <!-- ##########################################MODAL StART############################################### -->

                                <!-- Modal showModal form -->
                                <div class="container">


                                    <div class="modal fade" id="showModal" role="dialog">

                                        <div class="modal-dialog " >

                                            <div class="modal-content" >

                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Corn Expression</h4>
                                                </div>

                                                <div class="modal-body">


                                                    <form class="form-horizontal">
                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6" for = "triggerName" ><b>Trigger Name : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="triggerName" readonly="true"/>
                                                            </div>

                                                        </div>

                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6" for = "jobName" ><b>Job Name : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="jobName" readonly="true"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6"for = "cronExpression" ><b>Corn Expression : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="cronExpression" readonly="true"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6" for = "pgId" ><b>PG Name : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="pgId" readonly="true"/>
                                                            </div>

                                                        </div>

                                                    </form>

                                                </div>

                                                <div class="modal-footer">
                                                    <!--                                                    <button type="submit" class="btn btn-success" onclick="">Submit</button>-->
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">close</button>
                                                </div>  

                                            </div>    

                                        </div>

                                    </div>



                                </div>
                                <!--showModal form ends-->

                                <!-- Modal editModal form starts-->
                                <div class="container">


                                    <div class="modal fade" id="editModal" role="dialog">

                                        <div class="modal-dialog " >

                                            <div class="modal-content" >

                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Corn Expression</h4>
                                                </div>

                                                <div class="modal-body">


                                                    <form class="form-horizontal" id='edit_form'>

                                                        <input class="form-control" type="hidden" id="edit_jobId"/>
                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6" for = "triggerName" ><b>Trigger Name : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="edit_triggerName" readonly="true"/>
                                                            </div>

                                                        </div>

                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6" for = "jobName" ><b>Job Name : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="edit_jobName" readonly="true"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6"for = "cronExpression" ><b>Corn Expression : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" maxlength="25" id="edit_cronExpression" onkeyup="validateCornExp()"/>
                                                                <span id="error" ></span>
                                                            </div>

                                                            <!--                                                            <div id="cronExpression_div"  style="display: none;"><span style="color: red;"></span></div>-->
                                                        </div>

                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6" for = "pgId" ><b>PG Name : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="edit_pgId" readonly="true"/>
                                                            </div>

                                                        </div>

                                                    </form>

                                                </div>

                                                <div class="modal-footer">
                                                    <!--                                                    <button type="submit" class="btn btn-success" onclick="saveJobById()" data-dismiss="modal">Submit</button>-->
                                                    <button type="submit" class="btn btn-success" onclick="saveJobById()" >Submit</button>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">close</button>
                                                </div>  

                                            </div>    

                                        </div>

                                    </div>

                                </div>
                                <!-- edit modal form ends -->


                                <!-- Modal deleteModal form starts-->
                                <div class="container">


                                    <div class="modal fade" id="deleteModal" role="dialog">

                                        <div class="modal-dialog " >

                                            <div class="modal-content" >

                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Corn Expression</h4>
                                                </div>

                                                <div class="modal-body">


                                                    <form class="form-horizontal" id='delete_form'>

                                                        <input class="form-control" type="hidden" id="delete_jobId"/>
                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6" for = "triggerName" ><b>Trigger Name : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="delete_triggerName" readonly="true"/>
                                                            </div>

                                                        </div>

                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6" for = "jobName" ><b>Job Name : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="delete_jobName" readonly="true"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6"for = "cronExpression" ><b>Corn Expression : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="delete_cronExpression" readonly="true"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group">

                                                            <label class="control-label col-sm-6" for = "pgId" ><b>PG Name : </b></label>
                                                            <div class="col-sm-6">
                                                                <input class="form-control" type="text" id="delete_pgId" readonly="true"/>
                                                            </div>

                                                        </div>

                                                    </form>

                                                </div>

                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-danger " data-toggle="modal" href=""  data-dismiss="modal" onclick="confirmDelete()">Delete</button>
                                                    <button type="button" class="btn btn-default " data-dismiss="modal">close</button>
                                                </div>  

                                            </div>    

                                        </div>

                                    </div>

                                </div>
                                <!-- delete modal form ends -->


                                <!-- ##########################################MODAL END############################################### -->



                            </section>
                        </div><!-- /content-panel -->
                    </div><!-- /col-lg-4 -->			
                </div><!-- /row -->





            </div>
        </div>

    </section><! --/wrapper -->
</section>



<script type="text/javascript">



    function getJobById(jobId)
    {

        $.ajax({
            url: "getjobSchedularbyid",
            data: {jobId: jobId},
            type: "GET",
            dataType: 'json',
            success: function (data) {

                // alert('data is+ ' + JSON.stringify(data));
                $("#triggerName").val(data.triggerName);
                $("#jobName").val(data.jobName);
                $("#cronExpression").val(data.cronExpression);
                $("#pgId").val(data.pgId);
                // $("#datepicker").val(data.dob);


            }
        });

    }

    function editJobById(jobId)
    {
        // 

        $.ajax({
            url: "getjobSchedularbyid",
            data: {jobId: jobId},
            type: "GET",
            dataType: 'json',
            success: function (data) {

                // alert('data is+ ' + JSON.stringify(data));
                $("#edit_triggerName").val(data.triggerName);
                $("#edit_jobName").val(data.jobName);
                $("#edit_cronExpression").val(data.cronExpression);
                $("#edit_pgId").val(data.pgId);
                $("#edit_jobId").val(data.jobId);


            }
        });

    }


    function saveJobById()
    {

        var job_Id = document.getElementById("edit_form").elements.namedItem("edit_jobId").value;
        var cornExp = document.getElementById("edit_form").elements.namedItem("edit_cronExpression").value;
        //alert('inside function....' + cornExp + job_Id);
        $.ajax({
            url: "savejobSchedularbyid",
            data: {jobId: job_Id, cornExpression: cornExp},
            type: "POST",
            // dataType: 'json',
            success: function (data) {

                if (data === false)
                {
                    alert('Enter Valid Cron Expression');
                    $('#editModal').modal('show');
                } else
                {
                    createJobSchedular();
                    $('#editModal').modal('hide');
                }

            }
        });

        $('#editModal').on('hidden.bs.modal', function () {
            document.getElementById("error").innerHTML = "";
        });

    }


    function deleteJobById(jobId)
    {



        $.ajax({
            url: "getjobSchedularbyid",
            data: {jobId: jobId},
            type: "GET",
            dataType: 'json',
            success: function (data) {

                // alert('data is+ ' + JSON.stringify(data));
                $("#delete_triggerName").val(data.triggerName);
                $("#delete_jobName").val(data.jobName);
                $("#delete_cronExpression").val(data.cronExpression);
                $("#delete_pgId").val(data.pgId);
                $("#delete_jobId").val(data.jobId);

            }
        });

    }

    function confirmDelete()
    {
        var job_Id = document.getElementById("delete_form").elements.namedItem("delete_jobId").value;
        var result = confirm("Are you sure to delete Job_Id " + job_Id + "?");
        if (result === true)
        {
            $.ajax({
                url: "deleteJobSchedularbyid",
                data: {jobId: job_Id},
                type: "POST",
                //dataType: 'json',
                success: function (data) {

                    alert(data);

                }
            });

        } else
        {
            alert('Record not deleted');
        }
    }










    $(document).ready(function () {

        CreateHtmlTable();
        setInterval(CreateHtmlTable, 10000);
        createJobSchedular();

    }
    );

//  Quartz Schedular Table
    function CreateHtmlTable() {

        //Clear result div
        $("#ResultArea").html("");

        //Crate table html tag
        var table = $("<table id=DynamicTable class='table table-striped table-bordered'></table>").appendTo("#ResultArea");

        //Create table header row
        var rowHeader = $("<tr class='info'></tr>").appendTo(table);
        $("<th></th>").text("#").appendTo(rowHeader);
        $("<th></th>").text("Trigger Name").appendTo(rowHeader);
        $("<th></th>").text("Prev Fire Time").appendTo(rowHeader);
        $("<th></th>").text("Next Fire Time").appendTo(rowHeader);
        //        $("<th></th>").text("End Time").appendTo(rowHeader);
        $("<th></th>").text("Trigger State").appendTo(rowHeader);
        $("<th></th>").text("CronExpression").appendTo(rowHeader);
        $("<th></th>").text("Description").appendTo(rowHeader);


        //Get JSON data by calling action method in controller
        $.get('quartzList', function (data) {
            $.each(data, function (i, value) {

                //Create new row for each record


                if (i % 2 === 0) {
                    var row = $("<tr class='active'></tr>").appendTo(table);
                } else {
                    var row = $("<tr class='success'></tr>").appendTo(table);
                }
                $("<td></td>").text((i + 1)).appendTo(row);
                $("<td></td>").text(value.triggerName).appendTo(row);
                $("<td></td>").text(value.prevFireTime).appendTo(row);
                $("<td></td>").text(value.nextFireTime).appendTo(row);
                //                $("<td></td>").text(value.endTime).appendTo(row);
                $("<td></td>").text(value.triggerState).appendTo(row);
                $("<td title='" + value.description + "'></td>").text(value.cronExpression).appendTo(row);
                $("<td></td>").text(value.description).appendTo(row);


            });
        });
    }



//  Job scheduler Table   
    function createJobSchedular() {





        $("#JobSchedularResultArea").html("");

        var table = $("<table id=DynamicJobTable class='table table-striped table-bordered'></table>").appendTo("#JobSchedularResultArea");

        var rowHeader = $("<tr class='info'></tr>").appendTo(table);
        $("<th></th>").text("#").appendTo(rowHeader);
        $("<th></th>").text("Trigger Name").appendTo(rowHeader);
        $("<th></th>").text("Job Name").appendTo(rowHeader);
        $("<th></th>").text("Corn Expression").appendTo(rowHeader);
//        $("<th></th>").text("Job ID").appendTo(rowHeader);
//        $("<th></th>").text("PG Name").appendTo(rowHeader);
        $("<th></th>").text("Action").appendTo(rowHeader);


        $.get('getJobSchedularlist', function (data) {


            //alert('Function loaded...' + JSON.stringify(data));
            $.each(data, function (i, value) {

                //Create new row for each record


                if (i % 2 === 0) {
                    var row = $("<tr class='active'></tr>").appendTo(table);
                } else {
                    var row = $("<tr class='success'></tr>").appendTo(table);
                }
                $("<td></td>").text((i + 1)).appendTo(row);
                $("<td></td>").text(value.triggerName).appendTo(row);
                $("<td></td>").text(value.jobName).appendTo(row);
                $("<td class='expressinTextblock',title=''></td>").text(value.cronExpression).appendTo(row);
//                $("<td></td>").text(value.jobId).appendTo(row);
//                $("<td></td>").text(value.pgId).appendTo(row);
                var showModal = "<a class='btn btn-success btn-xs fa fa-eye' data-toggle='modal' data-target='#showModal' href=''  title='show' onclick='getJobById(" + value.jobId + ")'><i></i></a>";
                var editModal = "<a class='btn btn-primary btn-xs fa fa-pencil' data-toggle='modal' data-target='#editModal' href=''  title='edit' onclick='editJobById(" + value.jobId + ")'><i></i></a>";
                var deleteModal = "<a class='btn btn-danger btn-xs fa fa-trash-o' data-toggle='modal' data-target='#deleteModal' href=''  title='delete' onclick='deleteJobById(" + value.jobId + ")'><i></i></a>";
                $("<td>" + showModal + " " + editModal + " " + deleteModal + "</td>").appendTo(row);



            });
        });

    }



</script>


<script>
    $(document).ready(function () {


        $(".dispTooltip").tooltip({
            content: doAjax
        });


        function doAjax() {

            var returnValue = "";
            var exp = $(this).text();
            // alert('expression '+$(this).text());

            $.ajax({
                type: 'get',
                url: "getconExpressionText",
                data: {conExpression: exp},
                contentType: 'application/json; charset=utf-8',
                async: false, //while this is not generally good practice, it works here
                success: function (data) {

                    // returnValue = JSON.stringify(data);
                    returnValue = data;
                    // alert('data is: '+returnValue);

                }
            });
            // alert("ok...."+returnValue);
            return returnValue;
        }


    });



//    $('#edit_cronExpression').on('input', function () {
//        var conExpression = $('#edit_cronExpression').val();
//
//        alert(conExpression.length);
//    });

</script>


<script type="text/javascript">
    $(document).ready(function () {
        $(".expressinTextblock").mouseover(function () {
            var conExpression = $(this).text();
            //(this).attr('title', conExpression);

            var elemment = $(this);

            $.ajax({
                url: "getconExpressionText",
                data: {conExpression: conExpression},
                type: "GET",
                success: function (data) {

                    elemment.attr('title', data);


                }
            });

        });
    });




    <%-- 

Pravin Kumbhar 

Cron Expression over Call dynamic gener on use 

Discription:

    --%>
    $('body').on('mouseover', ".expressinTextblock", function () {

        var conExpression = $(this).text();

        var elemment = $(this);

        $.ajax({
            url: "getconExpressionText",
            data: {conExpression: conExpression},
            type: "GET",
            success: function (data) {

                elemment.attr('title', data);


            }
        });

    });

</script>

<%-- 

Pravin Kumbhar 

Cron Expression generator

Discription:

--%>

<script type="text/javascript">
    $(document).ready(function () {

        $('#cronExpressionDiv').cron({
            initial: "0 0/1 * * * ?",

            onChange: function () {
                $('#cronExpressionGenerator').text($(this).cron("value"));
                getconExpressionText($(this).cron("value"));
            },
            effectOpts: {
                openEffect: "fade",
                openSpeed: "slow"
            },
            customValues: {
                "5 Minutes": "0 0/5 * * * ?",
                "10 Minutes": "0 0/10 * * * ?",
                "15 Minutes": "0 0/15 * * * ?",
                "30 Minutes": "0 0/30 * * * ?",
                //"2 Hours on Weekends" : "0 */2 * * 5,6"
            },
            useGentleSelect: true
        });

    });
</script>



<%-- 

Pravin Kumbhar 

Cron Expression : human redable text

Discription:

--%>
<script type="text/javascript">

    function getconExpressionText(conExpression) {


        $.ajax({
            url: "getconExpressionText",
            data: {conExpression: conExpression},
            type: "GET",
            success: function (data) {

                //alert(data);
                $('#genratedCronExpression').text(data);

            }
        });




    }




    function validateCornExp()
    {
        var cornExp = document.getElementById("edit_form").elements.namedItem("edit_cronExpression").value;
        //alert('inside function....' + cornExp + job_Id);
        $.ajax({
            url: "validateCornExpression",
            data: {cornExpression: cornExp},
            type: "POST",
            // dataType: 'json',
            success: function (data) {

                if (data === "null") {
                    document.getElementById("error").innerHTML = "Enter Valid Cron Expression";
                    document.getElementById("error").style.color = "red";
                } else {
                    document.getElementById("error").innerHTML = data;
                    document.getElementById("error").style.color = "green";
                }

            }
        });

    }


</script>




