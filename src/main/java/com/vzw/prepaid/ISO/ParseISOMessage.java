package com.vzw.prepaid.ISO;

import java.io.IOException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

import com.vzw.prepaid.Message;

public class ParseISOMessage {

	public static void main(String[] args) throws IOException, ISOException {
		// Create Packager based on XML that contain DE type
		GenericPackager packager = new GenericPackager("basic.xml");

		// Print Input Data
		String data = "0200B2200000001000000000000000800000201234000000010000011072218012345606A5DFGR021ABCDEFGHIJ 1234567890";
		System.out.println("DATA : " + data);

		// Create ISO Message
		ISOMsg isoMsg = new ISOMsg();
		isoMsg.setPackager(packager);
		isoMsg.unpack(data.getBytes());

		// print the DE list
		logISOMsg(isoMsg);
	}

	private static void logISOMsg(ISOMsg msg) 
	{
		Message msge = new Message();
			System.out.println("----ISO MESSAGE-----");
			try 
			{
				System.out.println("  MTI : " + msg.getMTI());
				msge.setMsgTypeIndicator(msg.getMTI());
				for (int i=1;i<=msg.getMaxField();i++) {
					if (msg.hasField(i)) {
						if(i==3)
						{
							msge.setBitMap(msg.getString(i));
						}
						else if(i == 4)
						{
							msge.setProcessingCode(msg.getString(i));
						}
						else if(i == 7)
						{
							msge.setAmount(msg.getString(i));
						}
						else if(i == 11)
						{
							msge.setSysTraceAuditNo(msg.getString(i));
						}
						else if(i == 44)
						{
							msge.setAdditionalRespData(msg.getString(i));
						}
						else if(i == 105)
						{
							msge.setReservedIsoUse(msg.getString(i));
						}
						System.out.println("    Field-"+i+" : "+msg.getString(i));
					}
				}
				System.out.println("Message from object ::"+msge.toString());

			} catch (ISOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("--------------------");
			}
	 
		}

	public Message getMsgObject(String data) throws ISOException
	{
		GenericPackager packager = new GenericPackager(this.getClass().getClassLoader().getResource("basic.xml").getPath());

		// Print Input Data
		//String data = "0200B2200000001000000000000000800000201234000000010000011072218012345606A5DFGR021ABCDEFGHIJ 1234567890";
		System.out.println("DATA : " + data);

		// Create ISO Message
		ISOMsg msg = new ISOMsg();
		msg.setPackager(packager);
		msg.unpack(data.getBytes());

		Message msge = new Message();
		System.out.println("----ISO MESSAGE-----");
		try 
		{
			System.out.println("  MTI : " + msg.getMTI());
			msge.setMsgTypeIndicator(msg.getMTI());
			for (int i=1;i<=msg.getMaxField();i++) {
				if (msg.hasField(i)) {
					if(i==3)
					{
						msge.setProcessingCode(msg.getString(i));
					}
					else if(i == 4)
					{
						msge.setAmount(msg.getString(i));
					}
					else if(i == 7)
					{
						msge.setTransmissionDateTime(msg.getString(i));
					}
					else if(i == 11)
					{
						msge.setSysTraceAuditNo(msg.getString(i));
					}
					else if(i == 44)
					{
						msge.setAdditionalRespData(msg.getString(i));
					}
					else if(i == 105)
					{
						msge.setReservedIsoUse(msg.getString(i));
					}
					System.out.println("    Field-"+i+" : "+msg.getString(i));
				}
			}
			System.out.println("Message from object ::"+msge.toString());

		} catch (ISOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("--------------------");
		}
		return msge;
	}
}
