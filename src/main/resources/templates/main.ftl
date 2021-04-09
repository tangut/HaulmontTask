<#import "parts/common.ftl" as c>
<@c.page>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Client
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name of client" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="phoneNumber" placeholder="PhoneNumber">
                </div>
                <div class="form-group">
                     <input type="text" class="form-control" name="email" placeholder="Email">
                </div>
                <div class="form-group">
                      <input type="text" class="form-control" name="passportNumber" placeholder="PassportNumber">
                 </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>
    <div class="card-columns">
    <#list clients as client>
    <div class="card my-3">
         <div class="m-2">
        <br><span>Name: ${client.name}</span>
        <br><span>Phone: ${client.phoneNumber}</span>
        <br><span>Mail: ${client.email}</span>
        <br><span> Passport: ${client.passportNumber}</span>
        <br><a href="/clientEdit/${client.clientUUID}" class="btn btn-primary a-btn-slide-text">
               <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                <span><strong>Edit</strong></span>
            </a>
        </div>
    </div>
    <#else>
    No clients yet.
    </#list>
    </div>
</@c.page>