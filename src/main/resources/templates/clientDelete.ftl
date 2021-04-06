<#import "parts/common.ftl" as c>
<@c.page>
<#list clients as client>
Are you sure you want to delete this user?
<div class="card my-3">
     <div class="m-2">
    <br><span>Name: ${client.name}</span>
    <br><span>Phone Number: ${client.phoneNumber}</span>
    <br><span>Email: ${client.email}</span>
    <br><span> Passport Number: ${client.passportNumber}</span>
    </div>
</div>
<div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <class="form-control" name="name" placeholder="Name of client" value = "${client.name}" />
                </div>
                <div class="form-group">
                    <class="form-control" name="phoneNumber" placeholder="PhoneNumber" value = "${client.phoneNumber}">
                </div>
                <div class="form-group">
                     <class="form-control" name="email" placeholder="Email" value = "${client.email}">
                </div>
                <div class="form-group">
                      <class="form-control" name="passportNumber" placeholder="PassportNumber" value = "${client.passportNumber}">
                 </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
<#else>
No such client!
</#list>
</@c.page>