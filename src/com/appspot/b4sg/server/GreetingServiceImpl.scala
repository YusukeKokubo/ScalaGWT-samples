package com.appspot.b4sg.server

import com.google.gwt.user.server.rpc.RemoteServiceServlet
import com.appspot.b4sg.client.GreetingService
import org.slim3.datastore.Datastore
import com.appspot.b4sg.server.meta.CounterMeta
import com.appspot.b4sg.shared.model.Counter

class GreetingServiceImpl extends RemoteServiceServlet with GreetingService {
  
  val m = CounterMeta.get()

  override def hoge(s : String) : String = {
    "hello " + s
  }
  
  override def count() : Int = {
    val c = getOrCreateCount
    c.setCount(c.getCount() + 1)
    Datastore.put(c)
    c.getCount()
  }
  
  override def getCount() : Int = {
    val c = getOrCreateCount
    c.getCount()
  }
  
  def getOrCreateCount() : Counter = {
    var c = Datastore.query(m).limit(1).asSingle()
    if (c == null) c = new Counter
    c
  }
}