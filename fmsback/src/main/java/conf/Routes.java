/**
 * Copyright (C) the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Copyright (C) 2012-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package conf;

import ninja.AssetsController;

//import ninja.AssetsController;
import ninja.Router;

import ninja.application.ApplicationRoutes;
import ninja.utils.NinjaProperties;

import com.google.inject.Inject;

import controllers.FlightController;
import controllers.ApiController;
import controllers.ApplicationController;
import controllers.ArticleController;
import controllers.BookinngController;
import controllers.CorsHeaderController;
import controllers.LoginLogoutController;
import controllers.UserController;



public class Routes implements ApplicationRoutes {
    
    @Inject
    NinjaProperties ninjaProperties;

    /**
     * Using a (almost) nice DSL we can configure the router.
     * 
     * The second argument NinjaModuleDemoRouter contains all routes of a
     * submodule. By simply injecting it we activate the routes.
     * 
     * @param router
     *            The default router of this application
     */
    @Override
    public void init(Router router)  {  
        
    	
        // puts test data into db:
        if (!ninjaProperties.isProd()) {
            router.GET().route("/setup").with(ApplicationController::setup);
        }
        
        
        
        ///////////////////////////////////////////////////////////////////////
        // Login / Logout
        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/login").with(LoginLogoutController::login);
//        router.POST().route("/login").with(LoginLogoutController::loginPost);
//        router.GET().route("/logout").with(LoginLogoutController::logout);
        
        ///////////////////////////////////////////////////////////////////////
       
       
        
        // Create new article
        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/article/new").with(ArticleController::articleNew);
//        router.POST().route("/article/new").with(ArticleController::articleNewPost);
        
        //for flights
        router.OPTIONS().route("/.*").with(CorsHeaderController::routeForOp);
//        router.OPTIONS().route("/flight/new").with(CorsHeaderController::routeForOp);
        router.POST().route("/flight/new").with(FlightController::addNewFlight);
        router.GET().route("/flights").with(FlightController::allFlights);
        router.DELETE().route("/delete/{id}").with(FlightController::deleteFlight);
        router.PUT().route("/update").with(FlightController::updateFlight);
        
        
//        for booking
        router.POST().route("/booking/add").with(BookinngController::addNewBooking);
        router.GET().route("/bookings").with(BookinngController::allBooking);
        router.DELETE().route("/bookdelete/{id}").with(BookinngController::deleteBooking);
        
//        for users
        router.GET().route("/users").with(UserController::allUsers);
        router.POST().route("/user/new").with(UserController::addUser);
        router.DELETE().route("/userdelete/{id}").with(UserController::deleteUser);
        

        ///////////////////////////////r.//////////////////////////////////////
        // Create new article
        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/article/{id}").with(ArticleController::articleShow);

        ///////////////////////////////////////////////////////////////////////
        // Api for management of software
//        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/api/{username}/articles.json").with(ApiController::getArticlesJson);
//        router.GET().route("/api/{username}/article/{id}.json").with(ApiController::getArticleJson);
//        router.GET().route("/api/{username}/articles.xml").with(ApiController::getArticlesXml);
//        router.POST().route("/api/{username}/article.json").with(ApiController::postArticleJson);
//        router.POST().route("/api/{username}/article.xml").with(ApiController::postArticleXml);
// 
//        ///////////////////////////////////////////////////////////////////////
//        // Assets (pictures / javascript)
//        ///////////////////////////////////////////////////////////////////////    
//        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController::serveWebJars);
//        router.GET().route("/assets/{fileName: .*}").with(AssetsController::serveStatic);
        
        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
        router.GET().route("/.*").with(ApplicationController::index);
    }

}
