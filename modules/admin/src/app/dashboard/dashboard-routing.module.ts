import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {DashboardComponent} from "./dashboard.component";
import {DashboardResolve} from "./dashboard.resolve";
import {DashboardCreateComponent} from "./dashboard-create/dashboard-create.component";
import {DashboardUpdateComponent} from "./dashboard-update/dashboard-update.component";
import {DashboardUpdateResolve} from "./dashboard-update/dashboard-update.resolve";
import {DashboardDeleteComponent} from "./dashboard-delete/dashboard-delete.component";
import {DashboardsComponent} from "./dashboards/dashboards.component";
import {DashboardsResolve} from "./dashboards/dashboards.resolve";

const ROUTE_PROVIDER = [
    {
        path: 'create',
        component: DashboardCreateComponent
    },
    {
        path: ':id/update',
        component: DashboardUpdateComponent,
        resolve: {
            update: DashboardUpdateResolve
        }
    },
    {
        path: ':id/delete',
        component: DashboardDeleteComponent,
    },
    {
        path: ':id',
        component: DashboardComponent,
        resolve: {
            dashboard: DashboardResolve
        }
    },
    {
        path: '',
        component: DashboardsComponent,
        resolve: {
            dashboards: DashboardsResolve
        }
    }
];

@NgModule({
    imports: [RouterModule.forChild(ROUTE_PROVIDER)],
    exports: [RouterModule]
})
export class DashboardRoutingModule {
}
