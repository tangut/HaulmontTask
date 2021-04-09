<#import "parts/common.ftl" as c>
<@c.page>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Credit Offer
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="nameClient" placeholder="Name of client" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="nameCredit" placeholder="Name of Credit">
                </div>
                <div class="form-group">
                     <input type="text" class="form-control" name="sumCredit" placeholder="Sum of Credit">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>
    <div class="card-columns">
    <#list creditOffers as credit>
    <div class="card my-3">
         <div class="m-2">
        <br><span>Offer UUID: ${credit.offerUUID}</span>
        <br><span>Client Name: ${credit.client.name}</span>
        <br><span>Credit Name: ${credit.credit.creditName}</span>
        <br><span>Limit: ${credit.summCredit}</span>
        <br><a href="/creditOfferEdit/${credit.offerUUID}" class="btn btn-primary a-btn-slide-text">
               <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                <span><strong>Edit</strong></span>
            </a>
        </div>
    </div>
    <#else>
    No credit offers yet.
    </#list>
    </div>
</@c.page>