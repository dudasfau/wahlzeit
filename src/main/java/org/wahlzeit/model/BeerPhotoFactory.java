/*
 * Copyright (c) 2006-2017 by Sebastian Duda, https://meinewebsite.org
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import org.wahlzeit.others.Helpers;
import org.wahlzeit.others.annotations.Pattern;
import org.wahlzeit.services.LogBuilder;
import java.util.logging.Logger;


@Pattern(
        patternName = "Singleton",
        participants = {BeerPhotoFactory.class}
)
public class BeerPhotoFactory extends PhotoFactory {
    private static final Logger log = Logger.getLogger(BeerPhotoFactory.class.getName());

    protected BeerPhotoFactory (){
        Helpers.printNfo();
    }

    public static void initialize (){
        getInstance();
    }

    /**
     * Public singleton access method.
     */
    public static synchronized PhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new BeerPhotoFactory());
        }

        return instance;
    }

    /**
     * @methodtype factory
     */
    public BeerPhoto createPhoto() {
        return new BeerPhoto();
    }

    /**
     * Creates a new photo with the specified id
     */
    public BeerPhoto createPhoto(PhotoId id) {
        return new BeerPhoto(id);
    }
}
