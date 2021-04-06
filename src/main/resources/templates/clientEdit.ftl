<#import "parts/common.ftl" as c>
<@c.page>
<#list clients as client>
<div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name of client" value = "${client.name}" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="phoneNumber" placeholder="PhoneNumber" value = "${client.phoneNumber}">
                </div>
                <div class="form-group">
                     <input type="text" class="form-control" name="email" placeholder="Email" value = "${client.email}">
                </div>
                <div class="form-group">
                      <input type="text" class="form-control" name="passportNumber" placeholder="PassportNumber" value = "${client.passportNumber}">
                 </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Edit</button>
                </div>
                <div class="form-group">
                <a href="/clientDelete/${client.clientUUID}" button type="submit" class="btn btn-primary">Delete</button></a>
                </div>
            </form>
        </div>
<#else>
No such client!
</#list>
</@c.page>