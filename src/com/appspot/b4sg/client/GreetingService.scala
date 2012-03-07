package com.appspot.b4sg.client

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath
import com.google.gwt.user.client.rpc.RemoteService

@RemoteServiceRelativePath("service.s3gwt")
trait GreetingService extends RemoteService {
  def hoge(name: String) : String
  def count() : Int
  def getCount() : Int
}