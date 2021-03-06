/**
 * Copyright (C) 2015 VanillaSource
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.vanillasource.jaywire.serialization;

import java.io.*;

public class SerializationUtils {
   private SerializationUtils() {
   }

   @SuppressWarnings("unchecked")
   public static <T> T serializeThenDeserialize(T object) throws IOException, ClassNotFoundException {
      return deserialize((Class<T>) object.getClass(), serialize(object));
   }

   @SuppressWarnings("unchecked")
   public static byte[] serialize(Object object) throws IOException, ClassNotFoundException {
      ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      ObjectOutputStream objectOut = new ObjectOutputStream(byteOut);
      objectOut.writeObject(object);
      objectOut.close();
      return byteOut.toByteArray();
   }

   @SuppressWarnings("unchecked")
   public static <T> T deserialize(Class<T> classOfT, byte[] bytes) throws IOException, ClassNotFoundException {
      ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
      ObjectInputStream objectIn = new ObjectInputStream(byteIn);
      return (T) objectIn.readObject();
   }
}

