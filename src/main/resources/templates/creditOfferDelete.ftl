<#import "parts/common.ftl" as c>
<@c.page>
<#list creditOffers as credit>
Are you sure you want to delete this credit offer?
<div class="card my-3">
     <div class="m-2">
    <br><span>Name of client: ${credit.client.name}</span>
    <br><span>Name of credit: ${credit.credit.creditName}</span>
    <br><span>Sum of credit: ${credit.summCredit}</span>
    </div>
</div>
<div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <class="form-control" name="nameClient" placeholder="Name of client" value = "${credit.client.name}" />
                </div>
                <div class="form-group">
                    <class="form-control" name="nameCredit" placeholder="Name of Credit" value = "${credit.credit.creditName}">
                </div>
                <div class="form-group">
                     <class="form-control" name="summCredit" placeholder="Sum of credit" value = "${credit.summCredit}">
                </div>
                <div class="form-group">
                       <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
<#else>
No such credit offer!
</#list>
</@c.page>