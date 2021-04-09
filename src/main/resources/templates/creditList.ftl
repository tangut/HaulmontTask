<#import "parts/common.ftl" as c>
<@c.page>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Credit
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name of credit" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="limit" placeholder="Limit">
                </div>
                <div class="form-group">
                     <input type="text" class="form-control" name="percent" placeholder="Percent">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>
    <div class="card-columns">
    <#list credits as credit>
    <div class="card my-3">
         <div class="m-2">
        <br><span>Name: ${credit.creditName}</span>
        <br><span>Limit: ${credit.limit}</span>
        <br><span>Percent: ${credit.percent}</span>
        <br><a href="/creditEdit/${credit.creditUUID}" class="btn btn-primary a-btn-slide-text">
               <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                <span><strong>Edit</strong></span>
            </a>
        </div>
    </div>
    <#else>
    No credits yet.
    </#list>
    </div>
</@c.page>